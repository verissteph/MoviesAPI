package com.stephanieverissimo.moviesapp.model

data class MovieResponse(
    var page: Int,
    var results: List<Movie>
)