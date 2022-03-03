package com.kindred.data_source.remote

import com.kindred.data.ResultData
import com.kindred.model.Games

interface RemoteDataSource {

    suspend fun gamesListData(jurisdiction: String, brand: String, deviceGroup: String, locale: String, currency: String, categories: String, clientId: String): ResultData<Games>
}