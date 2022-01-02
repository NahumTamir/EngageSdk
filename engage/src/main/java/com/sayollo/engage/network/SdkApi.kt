package com.sayollo.engage.network


import com.sayollo.engage.data.UserData
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

internal interface SdkApi {
    @POST("/update")
    fun initSdk(
        @Query("user_data") userData: UserData,
        ): Call<ServerResponse>
}

