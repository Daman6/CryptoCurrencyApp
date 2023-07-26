package com.example.cryptocurrencyapp.domain.use_case.get_msn

import android.util.Log
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.example.cryptocurrencyapp.domain.model.Msn
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMsnUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String,deviceId: String,deviceType: String,contentConsumption: String,download: Boolean): Flow<Resource<Msn>> = flow {
        try {
            emit(Resource.Loading())
            val msn = repository.getMsnApi(id,deviceId,deviceType,contentConsumption,download)
            Log.e("jfnjnf","data"+msn.vl_errorCode.toString())
            emit(Resource.Success(msn))
        }catch (e: HttpException){
            Log.e("jfnjnf","error1"+e.response()!!.errorBody()!!.contentLength().toString())
            val errorBody = e.response()!!.errorBody()!!.string()
            val errorJson = JSONObject(errorBody)
            val errorMessage = errorJson.getString("errorMessage")
            Log.e("erorrmesg",errorMessage.toString())
            emit(Resource.Error(e.localizedMessage?.toString() ?: "An unexpected error occured"))
        }catch (e:IOException){
            Log.e("jfnjnf","error2"+e.localizedMessage.toString())

            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }

    }
}