package com.example.kitsuapp.data.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kitsuapp.data.remote.apiservices.AnimeApiSerivce
import com.example.kitsuapp.models.model.MangaModel
import retrofit2.HttpException
import java.io.IOException

class AnimePagingSources(
    private val animeApiSerivce: AnimeApiSerivce
) : PagingSource<Int, MangaModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangaModel> {
        val position = params.key ?: 1
        val pageLimit = 20
        val pageOffset = position - 1

        return try {
            val response = animeApiSerivce.fetchAnime(pageLimit, pageOffset)
            val nextPage = response.links.next
            val nextPageNumber =
                if (nextPage == null) null
                else position + pageLimit

            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPageNumber
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MangaModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


}