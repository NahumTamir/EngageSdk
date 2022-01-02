package com.sayollo.engage.network

import android.util.Log
import com.sayollo.engage.data.UserData
import com.sayollo.engage.network.Retrofit
import com.sayollo.engage.network.SdkApi
import com.sayollo.engage.network.ServerResponse
import retrofit2.Response
const val BASE_URL = "https://dev-api.com"

internal class SendDataToServer {
    companion object {
        fun run(userData: UserData) {
            val call =
                Retrofit.getRetrofit(BASE_URL).create(SdkApi::class.java)
                    .initSdk(userData)
            try {
                val response: Response<ServerResponse> = call.execute()
                if (response.isSuccessful) {
                    val isInitSuccessfully = response.body()?.serverUpdated
                    if (isInitSuccessfully == true) {
                        Log.i("TAMIR", "Initialization succeed")
                    } else {
                        Log.i("TAMIR", "Initialization failed")
                    }
                }
            } catch (throwable: Throwable) {
                Log.i("TAMIR", "run: ${throwable.message}")
            }
        }
    }
}