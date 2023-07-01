package com.example.homework4_android4.data.repository

import com.example.homework4_android4.base.BaseRepository
import com.example.homework4_android4.data.remote.apiservices.VideoApiService
import javax.inject.Inject

class VideoRepository @Inject constructor(private val service: VideoApiService) : BaseRepository() {

    fun fetchVideo(categoryId: String?) = doRequest {
        service.fetchVideo(categoryId = categoryId)
    }
}