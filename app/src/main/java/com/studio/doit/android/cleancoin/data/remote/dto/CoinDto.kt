package com.studio.doit.android.cleancoin.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.studio.doit.android.cleancoin.domain.model.Coin

data class CoinDto(
    val id: String,

    @SerializedName("is_active")
    val isActive: Boolean,

    @SerializedName("is_new")
    val isNew: Boolean,

    val name: String,

    val rank: Int,

    val symbol: String,

    val type: String
) {
    fun asCoin() : Coin = Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}