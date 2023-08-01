package com.stephanieverissimo.moviesapp.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stephanieverissimo.moviesapp.data.ApiService
import com.stephanieverissimo.moviesapp.model.Movie

class MoviePagingSource(
    private val movieApi: ApiService,
    private val apiKey: String
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = movieApi.discoverMovies(apiKey, nextPageNumber)

            LoadResult.Page(
                data = response.results,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (response.results.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

     override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
         TODO("Not yet implemented")
     }
 }
