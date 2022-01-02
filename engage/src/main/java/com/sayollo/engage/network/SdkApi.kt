package com.sayollo.engage.network


import com.sayollo.engage.InitializationResponse
import com.sayollo.engage.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query


internal interface SdkApi {
    @GET("/sdk_initialization")
    fun initSdk(
        @Query("user_data") userData: UserData,
        ): Call<InitializationResponse>
}

