package com.studio.doit.android.cleancoin.presentation.ui.coin.list

import com.studio.doit.android.cleancoin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String? = null
)