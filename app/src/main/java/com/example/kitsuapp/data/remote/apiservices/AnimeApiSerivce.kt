package com.example.kitsuapp.data.remote.apiservices

import com.example.kitsuapp.models.KitsuResponce
import com.example.kitsuapp.models.model.MangaModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiSerivce {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ):
            KitsuResponce<MangaModel>


}