package com.studio.doit.android.cleancoin.presentation.ui.coin.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.studio.doit.android.cleancoin.common.ParamKey
import com.studio.doit.android.cleancoin.common.Resource
import com.studio.doit.android.cleancoin.domain.usecase.coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(ParamKey.COIN_ID)?.let {
            loadCoinDetail(it)
        }
    }

    private fun loadCoinDetail(id: String) {
        getCoinUseCase(id).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = it.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = it.message
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}