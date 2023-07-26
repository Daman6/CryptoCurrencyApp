package com.example.cryptocurrencyapp.presentation.msn_component

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.model.Msn
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptocurrencyapp.domain.use_case.get_msn.GetMsnUseCase
import com.example.cryptocurrencyapp.presentation.coin_list.components.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MsnViewModel @Inject constructor(
    private val getMsnUseCase: GetMsnUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
{
    private val _states = mutableStateOf(MsnState())
    val state : State<MsnState> =_states

    init {
        getCoins(id = "5a092810-f1d2-471d-9612-9e26709c2503", deviceId = "9fa8ef3d08ce4e96", deviceType = "android_phone", contentConsumption = "android",false)
    }

    private fun getCoins(id: String,deviceId: String,deviceType: String,contentConsumption: String,download: Boolean){
        getMsnUseCase
        getMsnUseCase(id, deviceId, deviceType, contentConsumption, download).onEach {result ->
            when(result){
                is Resource.Success ->{
                    _states.value = MsnState(coins = result.data)
                }
                is Resource.Error ->{
                    _states.value = MsnState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _states.value =  MsnState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}