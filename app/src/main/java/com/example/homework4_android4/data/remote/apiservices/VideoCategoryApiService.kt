package com.example.homework4_android4.data.remote.apiservices

import com.example.homework4_android4.data.models.YoutubeResponse
import com.example.homework4_android4.data.models.category.VideoCategoryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoCategoryApiService {

    @GET("videoCategories")
    suspend fun fetchVideoCategory(
        @Query("part") part : String = "snippet",
        @Query("regionCode") regionCode: String = "ru",
        @Query("chart") chart: String = "mostPopular",
    ) : Response<YoutubeResponse<VideoCategoryModel>>
}