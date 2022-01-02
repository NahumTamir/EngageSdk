package com.sayollo.engage

import android.util.Log
import com.sayollo.engage.network.Retrofit
import com.sayollo.engage.network.SdkApi
import com.sayollo.engage.util.SdkConst
import retrofit2.Response

internal class UpdateDataInServer {
    companion object {
        fun run(userData: UserData) {
            val call =
                Retrofit.getRetrofit(SdkConst.BASE_URL).create(SdkApi::class.java)
                    .initSdk(userData)
            try {
                val response: Response<InitializationResponse> = call.execute()
                if (response.isSuccessful) {
                    val isInitSuccessfully = response.body()?.initSuccessfully
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