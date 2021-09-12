package com.studio.doit.android.cleancoin.presentation.ui.coin.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studio.doit.android.cleancoin.common.Resource
import com.studio.doit.android.cleancoin.domain.usecase.coin.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        loadCoins()
    }

    private fun loadCoins() {
        getCoinsUseCase().onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = it.message
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}