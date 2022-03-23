package com.zxcwldar.rickandmorty.data.remote

import com.zxcwldar.rickandmorty.common.constants.Constants.BASE_URL
import com.zxcwldar.rickandmorty.data.remote.apiservices.CharactersApiService
import com.zxcwldar.rickandmorty.data.remote.apiservices.EpisodesApiService
import com.zxcwldar.rickandmorty.data.remote.apiservices.LocationsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharactersApiService() =
        retrofit.create(CharactersApiService::class.java)


    fun provideLocationApiService() =
        retrofit.create(LocationsApiService::class.java)

    fun provideEpisodesApiService() =
        retrofit.create(EpisodesApiService::class.java)


}