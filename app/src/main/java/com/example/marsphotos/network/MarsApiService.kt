package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import com.example.marsphotos.config.Config




private val retrofit= Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(Config.BASE_URL)
    .build()

interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos() : String
}

object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}