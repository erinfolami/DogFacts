package com.example.dogfacts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiInstance {

    private val retrofitInstance by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: DogFactApi by lazy {
        retrofitInstance.create(DogFactApi::class.java)
    }
}