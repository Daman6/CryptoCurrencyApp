package com.example.cryptocurrencyapp.data.repository

import com.example.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import com.example.cryptocurrencyapp.data.remote.dto.CoinPaprikaApi
import com.example.cryptocurrencyapp.domain.model.Msn
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getMsnApi(id: String,deviceId: String,deviceType: String,contentConsumption: String,download: Boolean): Msn {
        return api.getMsnApi(id,deviceId, deviceType, contentConsumption, download)
    }
}