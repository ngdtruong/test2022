package com.example.test2022.repository

import android.content.Context
import com.example.test2022.api.ApiClient
import com.example.test2022.api.ClientInterface
import com.example.test2022.model.MediaList

class MediaRepositoryImpl constructor(context: Context) : MediaRepository {

    private val clientInterface: ClientInterface by lazy {
        ApiClient.retrofit!!.create(ClientInterface::class.java)
    }

    companion object {
        @Volatile
        private var instance: MediaRepositoryImpl? = null
        fun getInstance(context: Context): MediaRepositoryImpl? {
            if (instance == null) {
                synchronized(MediaRepositoryImpl::class.java) {
                    if (instance == null) {
                        instance = MediaRepositoryImpl(context.applicationContext)
                    }
                }
            }
            return instance
        }
    }

    override suspend fun fetchData(): List<MediaList> {
        return clientInterface.fetchData()
    }
}