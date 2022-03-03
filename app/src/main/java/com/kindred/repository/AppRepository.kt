package com.kindred.repository

import com.kindred.data.ResultData
import com.kindred.model.Games

interface AppRepository {

    suspend fun getAllGames(jurisdiction: String, brand: String, deviceGroup: String, locale: String, currency: String, categories: String, clientId: String): ResultData<Games>

}