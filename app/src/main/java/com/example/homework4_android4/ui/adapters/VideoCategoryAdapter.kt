package com.example.homework4_android4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4_android4.data.models.category.VideoCategoryModel
import com.example.homework4_android4.databinding.OneItemBinding

class VideoCategoryAdapter(private val onItemClick: (id: String?) -> Unit) :
    ListAdapter<VideoCategoryModel, VideoCategoryAdapter.AnimeViewHolder>(DiffUtilCallback()) {

    inner class AnimeViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tvTitle.setOnClickListener {
                val item: VideoCategoryModel? = getItem(absoluteAdapterPosition)
                onItemClick(item?.id)
            }
        }

        fun onBind(item: VideoCategoryModel) = with(binding) {
            tvTitle.text = item.snippet.title.trim()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        class DiffUtilCallback : DiffUtil.ItemCallback<VideoCategoryModel>() {

            override fun areItemsTheSame(
                oldItem: VideoCategoryModel,
                newItem: VideoCategoryModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: VideoCategoryModel,
                newItem: VideoCategoryModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}