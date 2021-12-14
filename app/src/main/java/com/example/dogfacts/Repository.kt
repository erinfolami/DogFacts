package com.example.dogfacts


class Repository {

    suspend fun getDogFact(): List<DogFact> {
        return ApiInstance.api.getDogFact()
    }
}