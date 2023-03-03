package com.example.startup

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MyAPI {
    @Headers("Content-Type: application/json", "ngrok-skip-browser-warning: abc")
    @POST("api/accounts/output/")
    suspend fun getData(@Body user: User): List<Mydata>
}