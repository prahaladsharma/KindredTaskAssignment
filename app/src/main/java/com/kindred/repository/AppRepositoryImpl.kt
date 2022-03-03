package com.kindred.repository

import com.kindred.data.RemoteDataNotFoundException
import com.kindred.data.ResultData
import com.kindred.data_source.remote.RemoteDataSource
import com.kindred.di.IoDispatcher
import com.kindred.model.Games
import kotlinx.coroutines.CoroutineDispatcher

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AppRepository {

    override suspend fun getAllGames(
        jurisdiction: String,
        brand: String,
        deviceGroup: String,
        locale: String,
        currency: String,
        categories: String,
        clientId: String
    ): ResultData<Games> {
        return when (val result = remoteDataSource.gamesListData(jurisdiction, brand, deviceGroup, locale, currency, categories,clientId)) {
            is ResultData.Success -> {
                val response = result.data
                ResultData.Success(response)
            }
            is ResultData.Error -> {
                ResultData.Error(RemoteDataNotFoundException())
            }
        }
    }

}