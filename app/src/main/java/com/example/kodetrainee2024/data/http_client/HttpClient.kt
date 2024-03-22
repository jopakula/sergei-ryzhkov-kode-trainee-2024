package com.example.kodetrainee2024.data.http_client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpClient {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://stoplight.io/mocks/kode-api/trainee-test/331141861/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val api = retrofit.create(Api::class.java)
}
