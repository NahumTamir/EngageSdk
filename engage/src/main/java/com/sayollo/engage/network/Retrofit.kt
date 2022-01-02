package com.sayollo.engage.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder

import com.google.gson.Gson




internal class AppRetrofit {
    companion object {
        @Volatile
        private var iInstance: Retrofit? = null
        var gson: Gson = GsonBuilder()
            .setLenient()
            .create()
        fun getRetrofit(url: String): Retrofit {
            val tempInstance = iInstance
            if (tempInstance != null) {
                return tempInstance
            } else {
                synchronized(this) {
                    val instance = Retrofit.Builder()
                        .baseUrl(url)
                        .client(AppOkHttpClient.getOkHttpClient())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                    iInstance = instance
                    return instance
                }
            }
        }
    }
}