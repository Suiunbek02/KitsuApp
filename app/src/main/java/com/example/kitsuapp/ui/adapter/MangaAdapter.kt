package com.example.kitsuapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsuapp.base.BaseDiffUtilItemCallback
import com.example.kitsuapp.databinding.ItemKitsuBinding
import com.example.kitsuapp.models.model.MangaModel

class MangaAdapter :
    PagingDataAdapter<MangaModel, MangaAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: MangaModel?) {
            binding.itemMangaTitle.text = item?.attributes?.title?.en_jp.toString()
            Glide
                .with(binding.itemMangaImage)
                .load(item?.attributes?.posterImage?.small.toString())
                .into(binding.itemMangaImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemKitsuBinding.inflate(
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