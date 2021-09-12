package com.studio.doit.android.cleancoin.data.repository

import com.studio.doit.android.cleancoin.data.remote.CoinApi
import com.studio.doit.android.cleancoin.data.remote.dto.CoinDetailDto
import com.studio.doit.android.cleancoin.data.remote.dto.CoinDto
import com.studio.doit.android.cleancoin.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {
    override suspend fun getCoin(id: String): CoinDetailDto = api.getCoin(id)

    override suspend fun getCoins(): List<CoinDto> = api.getCoins()
}