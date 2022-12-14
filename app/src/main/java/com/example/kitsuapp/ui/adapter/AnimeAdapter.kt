package com.example.kitsuapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapp.base.BaseDiffUtilItemCallback
import com.example.kitsuapp.databinding.ItemAnimeBinding
import com.example.kitsuapp.models.model.MangaModel

class AnimeAdapter :
    PagingDataAdapter<MangaModel, AnimeAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: MangaModel?) {
            binding.itemAnimeTitle.text = item?.attributes?.title?.en_jp.toString()
            Glide
                .with(binding.itemAnimeImage)
                .load(item?.attributes?.posterImage?.small.toString())
                .into(binding.itemAnimeImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}