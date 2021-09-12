package com.studio.doit.android.cleancoin.presentation.ui.coin.detail

import com.studio.doit.android.cleancoin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String? = null
)