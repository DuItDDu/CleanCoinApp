package com.studio.doit.android.cleancoin.di

import com.studio.doit.android.cleancoin.data.repository.CoinRepositoryImpl
import com.studio.doit.android.cleancoin.domain.repository.CoinRepository
import com.studio.doit.android.cleancoin.domain.usecase.coin.GetCoinUseCase
import com.studio.doit.android.cleancoin.domain.usecase.coin.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetCoinsUseCase(
        coinRepository: CoinRepositoryImpl
    ): GetCoinsUseCase =
        GetCoinsUseCase(coinRepository)

    @Singleton
    @Provides
    fun provideGetCoinUseCase(
        coinRepository: CoinRepositoryImpl
    ): GetCoinUseCase =
        GetCoinUseCase(coinRepository)
}