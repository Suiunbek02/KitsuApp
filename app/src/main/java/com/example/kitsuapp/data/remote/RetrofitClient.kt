package com.example.kitsuapp.data.remote

import com.example.kitsuapp.data.remote.apiservices.AnimeApiSerivce
import com.example.kitsuapp.data.remote.apiservices.MangaApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClient() = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInspector())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInspector(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun providerMangaApiService(): MangaApiService {
        return retrofit.create(MangaApiService::class.java)
    }

    fun providerAnimeApiService(): AnimeApiSerivce {
        return retrofit.create(AnimeApiSerivce::class.java)
    }


}