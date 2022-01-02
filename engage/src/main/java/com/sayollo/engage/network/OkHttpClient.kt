package com.sayollo.engage.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

internal class OkHttpClient : OkHttpClient() {
    companion object {
        @Volatile
        private var iInstance: OkHttpClient? = null
        fun getOkHttpClient(): OkHttpClient {
            return iInstance
                ?: synchronized(this) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    httpLoggingInterceptor.level =
                        HttpLoggingInterceptor.Level.BODY
                    Builder()
                        .connectTimeout(60L, TimeUnit.SECONDS)
                        .readTimeout(60L, TimeUnit.SECONDS)
                        .addInterceptor(httpLoggingInterceptor).build()
                }
        }
    }
}