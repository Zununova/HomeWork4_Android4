package com.example.homework4_android4.data.remote.apiservices

import com.example.homework4_android4.data.models.YoutubeResponse
import com.example.homework4_android4.data.models.video.VideoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApiService {

    @GET("videos")
    suspend fun fetchVideo(
        @Query("part") part: String = "snippet",
        @Query("regionCode") regionCode: String = "ru",
        @Query("chart") chart: String = "mostPopular",
        @Query("videoCategoryId") categoryId: String? = null
    ): Response<YoutubeResponse<VideoModel>>
}