package com.kindred.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Games(
    @SerializedName("games")
    @Expose
    val games: Map<String, WishesV94mg>
)
