package com.example.kodetrainee2024.data.http_client

import com.example.kodetrainee2024.data.http_client.response.Items
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @GET("users")
    @Headers("Prefer: code=200, example=success", "Accept: application/json, application/xml")
    suspend fun getUsers(): Items
}
