package com.example.dogfacts

import retrofit2.http.GET

interface DogFactApi {

    @GET("api/v1/resources/dogs?number=1")
    suspend fun getDogFact(): List<DogFact>
}