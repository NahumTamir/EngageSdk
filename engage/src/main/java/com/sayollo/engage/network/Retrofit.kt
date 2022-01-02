package com.sayollo.engage.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal class Retrofit {
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
                        .client(OkHttpClient.getOkHttpClient())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
                    iInstance = instance
                    return instance
                }
            }
        }
    }
}