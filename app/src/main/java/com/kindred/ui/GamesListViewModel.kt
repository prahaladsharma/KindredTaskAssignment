package com.kindred.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kindred.data.ResultData
import com.kindred.model.Games
import com.kindred.repository.AppRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesListViewModel @Inject constructor(
    private val gamesRepository: AppRepositoryImpl
): ViewModel() {

    val gameList = MutableLiveData<Games>()
    var resultHistory: LiveData<Games> = gameList

    private var _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    private var _showLoading = MutableLiveData<Boolean>()
    var showLoading: LiveData<Boolean> = _showLoading

    val loading = MutableLiveData<Boolean>()

    fun getListOfGames(jurisdiction: String,
                       brand: String,
                       deviceGroup: String,
                       locale: String,
                       currency: String,
                       categories: String,
                       clientId: String) {
        _showLoading.postValue(true)
        viewModelScope.launch {
            try {
                when (val response = gamesRepository.getAllGames(jurisdiction, brand, deviceGroup, locale, currency, categories,clientId)) {
                    is ResultData.Success -> {
                        _showLoading.postValue(false)
                        gameList.postValue(response.data)
                    }
                    is ResultData.Error -> {
                        _showLoading.postValue(false)
                        _errorMessage.postValue(response.exception.toString())
                    }
                }
            } catch (e: Exception) {
                _showLoading.postValue(false)
                _errorMessage.postValue(e.message)
            }
        }
    }

}