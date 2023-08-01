package com.stephanieverissimo.moviesapp.data

import com.stephanieverissimo.moviesapp.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    suspend fun discoverMovies(@Query("api_key") apiKey:String, @Query("page") page: Int): MovieResponse
}