package com.stephanieverissimo.moviesapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.stephanieverissimo.moviesapp.utils.MoviePagingSource
import com.stephanieverissimo.moviesapp.data.ApiService
import com.stephanieverissimo.moviesapp.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieApi: ApiService) {
    fun getMovies(apiKey: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { MoviePagingSource(movieApi, apiKey) }
        ).flow
    }
}
