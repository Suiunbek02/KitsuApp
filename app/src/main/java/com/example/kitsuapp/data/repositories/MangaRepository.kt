package com.example.kitsuapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kitsuapp.base.BaseRepository
import com.example.kitsuapp.data.pagingsources.MangaPagingSources
import com.example.kitsuapp.data.remote.apiservices.MangaApiService
import com.example.kitsuapp.models.model.MangaModel
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val service: MangaApiService
) : BaseRepository() {

//    fun fetchsKitsu() = doRequest {
//        service.fetchKitsu()
//    }

    fun fetchManga(): LiveData<PagingData<MangaModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                MangaPagingSources(service)
            }, initialKey = 1
        ).liveData
    }


}