package com.studio.doit.android.cleancoin.data.remote

import com.studio.doit.android.cleancoin.data.remote.dto.CoinDetailDto
import com.studio.doit.android.cleancoin.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoin(
        @Path("coinId") coinId: String
    ) : CoinDetailDto
}