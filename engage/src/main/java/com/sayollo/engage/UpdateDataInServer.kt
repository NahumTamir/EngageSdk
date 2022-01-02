package com.sayollo.engage

import android.util.Log
import com.sayollo.engage.network.AppRetrofit
import com.sayollo.engage.network.SdkApi
import com.sayollo.engage.util.SdkConst
import retrofit2.Response

internal class UpdateDataInServer {
    companion object {
        fun run(userData: UserData) {
            val call =
                AppRetrofit.getRetrofit(SdkConst.BASE_URL).create(SdkApi::class.java)
                    .initSdk(userData)
            try {
                val response: Response<InitializationResponse> = call.execute()
                if (response.isSuccessful) {
                    val isInitSuccessfully = response.body()?.isTest
                    if (isInitSuccessfully == true) {
                        Log.i("TAMIR", "Initialization succeed")
                    } else {
                        Log.i("TAMIR", "isInitSuccessfully == false")
                    }
                }
            } catch (throwable: Throwable) {
                Log.i("TAMIR", "run: ${throwable.message}")
            }
        }
    }
}