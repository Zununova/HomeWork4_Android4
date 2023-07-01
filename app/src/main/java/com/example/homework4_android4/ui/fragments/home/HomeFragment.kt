package com.example.homework4_android4.ui.fragments.home

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework4_android4.R
import com.example.homework4_android4.base.BaseFragment
import com.example.homework4_android4.databinding.FragmentHomeBinding
import com.example.homework4_android4.ui.adapters.VideoAdapter
import com.example.homework4_android4.ui.adapters.VideoCategoryAdapter
import com.example.homework4_android4.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override val viewBinding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel: HomeViewModel by viewModels()
    private val videoCategoryAdapter = VideoCategoryAdapter(this::onItemCLick)
    private val videoAdapter = VideoAdapter()

    private fun onItemCLick(id: String?) {
        viewModel.fetchVideo(id).observe(viewLifecycleOwner) { it ->
            when (it) {
                is Resource.Error ->
                    Log.e(TAG, "error" )
                is Resource.Loading ->
                    Log.e(TAG, "loading" )
                is Resource.Success ->
                    videoAdapter.submitList(it.data?.items)
            }
        }
    }

    override fun initialize() {
        super.initialize()

        viewBinding.recyclerViewVideoCategory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = videoCategoryAdapter
        }

        viewBinding.recyclerViewVideo.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = videoAdapter
        }
    }

    override fun setupSubscribes() {
        super.setupSubscribes()

        videoCategorySubscribe()
        videoSubscribe()
    }

    private fun videoCategorySubscribe() {


        viewModel.fetchVideoCategory().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error ->
                    Log.e(TAG, "error" )
                is Resource.Loading ->
                    Log.e(TAG, "loading" )
                is Resource.Success ->
                    videoCategoryAdapter.submitList(it.data?.items)
            }
        }
    }

    private fun videoSubscribe() {
        viewModel.fetchVideo("0").observe(viewLifecycleOwner) { it ->
            when (it) {
                is Resource.Error ->
                    Log.e(TAG, "error" )
                is Resource.Loading ->
                    Log.e(TAG, "loading" )
                is Resource.Success ->
                    videoAdapter.submitList(it.data?.items)
            }
        }
    }
}