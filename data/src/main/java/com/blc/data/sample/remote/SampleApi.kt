package com.blc.data.sample.remote

import com.blc.domain.sample.model.SampleModel
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {
    @GET("/ge/samples")
    suspend fun getSamples(): Response<List<SampleModel>>
}