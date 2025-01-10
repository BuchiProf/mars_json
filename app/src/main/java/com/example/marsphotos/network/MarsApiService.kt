package com.example.marsphotos.network

import androidx.compose.runtime.Composition
import retrofit2.Retrofit

import retrofit2.http.GET
import com.example.marsphotos.config.Config
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory


private val retrofit= Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(Config.BASE_URL)
    .build()

interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>
}

object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}