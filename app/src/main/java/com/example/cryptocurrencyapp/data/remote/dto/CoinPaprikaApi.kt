package com.example.cryptocurrencyapp.data.remote.dto

import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.example.cryptocurrencyapp.domain.model.Msn
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId:String): CoinDetailDto

    @Headers("authorization: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiI3ZGNlZWE3OS0xZWY0LTQ1MGUtODY1My04YmQ1Nzc2YmU5NGMiLCJzaXRlIjoibXNuZGV2Iiwic2l0ZUlkIjoiMDAwMDAxNTEtMTFiNC1kMjliLWExN2QtNTVmZGIyYjgwMDAwIiwiZW1haWwiOiJkYXNzLmhhcmlzaEBnbWFpbC5jb20iLCJpcGFkZHJlc3NlcyI6IjEzOS41LjI1NC4zNCwgMTMwLjE3Ni4xODguMjExLDE5Mi4xNjguODQuNzIsIDU0LjE3NC4yMC4yMSwgMTMwLjE3Ni4xMzcuODciLCJjb3VudHJ5Q29kZSI6IklOIiwicG9zdGFsY29kZSI6IjExMDAwMyIsInByb3ZpZGVyIjoidmlld2xpZnQiLCJkZXZpY2VJZCI6ImEwYjJkMWZiMmVmZmNkZWYiLCJpZCI6IjdkY2VlYTc5LTFlZjQtNDUwZS04NjUzLThiZDU3NzZiZTk0YyIsInBob25lTnVtYmVyIjoiKzkxODgwMDEyODI1MSIsImlhdCI6MTY4MzE4NDE0NiwiZXhwIjoxNjgzMTg0NDQ2fQ.xZ9RkzvotgZxS0QtximTqfwL4SYH08AMRRM52Hft-BA")
    @GET("/entitlement/video/status")
    suspend fun getMsnApi(
        @Query("id") id: String,
        @Query("deviceId") deviceId: String,
        @Query("deviceType") deviceType: String,
        @Query("contentConsumption") contentConsumption: String,
        @Query("download") download: Boolean
    ): Msn
}