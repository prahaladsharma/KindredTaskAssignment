package com.kindred.data_source.remote

import com.kindred.api.ApiService
import com.kindred.data.ResultData
import com.kindred.di.IoDispatcher
import com.kindred.model.Games
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(
    private val api: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : RemoteDataSource {

    override suspend fun gamesListData(jurisdiction: String,brand: String,
                                       deviceGroup: String, locale: String,
                                       currency: String, categories: String,
                                       clientId: String): ResultData<Games> =
        withContext(ioDispatcher){
            val request = api.getGamesList(jurisdiction, brand, deviceGroup, locale, currency, categories,clientId)
            ResultData.Success(request)
        }
}