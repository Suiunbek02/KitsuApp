package com.example.kitsuapp.data.remote.apiservices

import com.example.kitsuapp.models.KitsuResponce
import com.example.kitsuapp.models.model.MangaModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchKitsu(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ):
            KitsuResponce<MangaModel>

}