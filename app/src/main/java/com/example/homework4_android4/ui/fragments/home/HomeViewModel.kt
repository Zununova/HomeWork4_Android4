package com.example.homework4_android4.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.homework4_android4.base.BaseViewModel
import com.example.homework4_android4.data.repository.SearchRepository
import com.example.homework4_android4.data.repository.VideoCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: VideoCategoryRepository,
    private val searchRepository: SearchRepository
) : BaseViewModel() {

    fun fetchVideoCategory() = repository.fetchVideoCategory()

    fun fetchVideo(id: String?) = searchRepository.fetchVideo(id)
}