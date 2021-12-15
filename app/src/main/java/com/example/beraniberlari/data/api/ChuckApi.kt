package com.example.beraniberlari.data.api

import com.example.beraniberlari.data.model.ChuckResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChuckApi {

    @GET("/jokes/random")
    suspend fun getChuck(
    ): Response<ChuckResponse>

}