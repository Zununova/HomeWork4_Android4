package com.example.homework4_android4.data.repository

import com.example.homework4_android4.base.BaseRepository
import com.example.homework4_android4.data.remote.apiservices.VideoCategoryApiService
import javax.inject.Inject

class VideoCategoryRepository @Inject constructor(private val service: VideoCategoryApiService) :
    BaseRepository() {

    fun fetchVideoCategory() = doRequest {
        service.fetchVideoCategory()
    }

}