package com.kindred.api

import com.kindred.model.Games
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("getGamesByMarketAndDevice.json?")
    suspend fun getGamesList(@Query("jurisdiction") jurisdiction: String,
                             @Query("brand") brand: String,
                             @Query("deviceGroup") deviceGroup: String,
                             @Query("locale") locale: String,
                             @Query("currency") currency: String,
                             @Query("categories") categories: String,
                             @Query("clientId") clientId: String): Games
}