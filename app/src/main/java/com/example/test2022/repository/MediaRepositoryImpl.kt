package com.example.test2022.repository

import com.example.test2022.api.ApiClient
import com.example.test2022.api.ClientInterface
import com.example.test2022.model.MediaList

class MediaRepositoryImpl : MediaRepository {

    private val clientInterface: ClientInterface by lazy {
        ApiClient.retrofit.create(ClientInterface::class.java)
    }

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { MediaRepositoryImpl() }
    }

    override suspend fun fetchData(): List<MediaList> {
        return clientInterface.fetchData()
    }
}