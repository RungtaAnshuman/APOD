package com.test.apod.api

import com.test.apod.models.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodService {

    @GET("planetary/apod")
    suspend fun getData(@Query("api_key") apiKey: String) : Response<DataModel>

}