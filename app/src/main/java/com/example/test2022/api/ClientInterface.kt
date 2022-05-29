package com.example.test2022.api

import com.example.test2022.model.MediaList
import retrofit2.http.GET

interface ClientInterface {
    @GET(Constant.GET_DATA)
    suspend fun fetchData(): List<MediaList>
}