package com.example.homework4_android4.data.remote

import com.example.homework4_android4.data.remote.apiservices.VideoApiService
import com.example.homework4_android4.data.remote.apiservices.VideoCategoryApiService
import com.example.homework4_android4.data.remote.interceptors.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okkHttClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(ApiKeyInterceptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/v3/")
        .client(okkHttClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )

    fun provideVideoCategoryApiService() =
        retrofitClient.create(VideoCategoryApiService::class.java)

    fun provideSearchApiService() =
        retrofitClient.create(VideoApiService::class.java)
}