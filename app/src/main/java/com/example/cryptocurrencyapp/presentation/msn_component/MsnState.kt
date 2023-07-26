package com.example.cryptocurrencyapp.presentation.msn_component

import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.Msn

data class MsnState(
    val isLoading: Boolean = false,
    val coins : Msn? = null,
    val error : String = " "
)
