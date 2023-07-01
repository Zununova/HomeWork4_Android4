package com.example.homework4_android4.ui.fragments.home

import com.example.homework4_android4.base.BaseViewModel
import com.example.homework4_android4.data.repository.VideoRepository
import com.example.homework4_android4.data.repository.VideoCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: VideoCategoryRepository,
    private val searchRepository: VideoRepository
) : BaseViewModel() {

    fun fetchVideoCategory() = repository.fetchVideoCategory()

    fun fetchVideo(id: String?) = searchRepository.fetchVideo(id)
}