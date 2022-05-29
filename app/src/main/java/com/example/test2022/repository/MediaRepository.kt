package com.example.test2022.repository

import com.example.test2022.model.MediaList

interface MediaRepository {
    suspend fun fetchData(): List<MediaList>
}