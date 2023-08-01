package com.stephanieverissimo.moviesapp.model

import com.google.gson.annotations.SerializedName

data class Movie(
    var id: String,
    var title: String,
    var overview: String,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("vote_average")
    var voteAverange: Double,
    )