package com.studio.doit.android.cleancoin.domain.repository

import com.studio.doit.android.cleancoin.data.remote.dto.CoinDetailDto
import com.studio.doit.android.cleancoin.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoin(id: String) : CoinDetailDto
}