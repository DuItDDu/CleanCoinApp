package com.studio.doit.android.cleancoin.di

import com.studio.doit.android.cleancoin.data.remote.CoinApi
import com.studio.doit.android.cleancoin.data.repository.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCoinRepository(
        coinApi: CoinApi
    ) : CoinRepositoryImpl =
        CoinRepositoryImpl(coinApi)
}