package com.studio.doit.android.cleancoin.domain.usecase.coin

import com.studio.doit.android.cleancoin.common.Resource
import com.studio.doit.android.cleancoin.domain.model.CoinDetail
import com.studio.doit.android.cleancoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            coinRepository.getCoin(coinId).asCoinDetail()
                .let { Resource.Success(it) }
                .let { emit(it) }
        } catch (e: Exception) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error."))
        }
    }
}