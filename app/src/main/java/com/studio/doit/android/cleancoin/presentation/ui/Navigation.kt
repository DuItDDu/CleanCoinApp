package com.studio.doit.android.cleancoin.presentation.ui

sealed class Navigation(val screen: String) {
    object CoinListScreen : Navigation("coin_list")
    object CoinDetailScreen : Navigation("coin_detail") {
        fun withId(id: String) =
            "$screen/${id}"
    }
}