package com.example.kitsuapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kitsuapp.base.BaseRepository
import com.example.kitsuapp.data.pagingsources.AnimePagingSources
import com.example.kitsuapp.data.remote.apiservices.AnimeApiSerivce
import com.example.kitsuapp.models.model.MangaModel
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiSerivce: AnimeApiSerivce
) : BaseRepository() {

    fun fetchAnime(): LiveData<PagingData<MangaModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                AnimePagingSources(animeApiSerivce)
            }, initialKey = 1
        ).liveData
    }

}