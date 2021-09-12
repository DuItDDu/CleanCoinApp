package com.studio.doit.android.cleancoin.domain.usecase.coin

import com.studio.doit.android.cleancoin.common.Resource
import com.studio.doit.android.cleancoin.domain.model.Coin
import com.studio.doit.android.cleancoin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            coinRepository.getCoins()
                .map { it.asCoin() }
                .let { emit(Resource.Success(it)) }
        } catch (e: Exception) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error."))
        }
    }


}