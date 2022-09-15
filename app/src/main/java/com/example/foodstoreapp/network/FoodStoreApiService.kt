package com.example.foodstoreapp.network

import com.example.foodstoreapp.model.Item
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Base Url for the webservice
private const val BASE_URL = "https://cailloutr.github.io/food-store-api/"


/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FoodStoreApiService {

    @GET("foodStoreApi.json")
    suspend fun getItems(): NetworkItemContainer
}

object FoodStoreApi {
    val retrofitService: FoodStoreApiService by lazy {
        retrofit.create(FoodStoreApiService::class.java)
    }
}
