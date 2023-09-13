package com.stephanieverissimo.moviesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.stephanieverissimo.moviesapp.BuildConfig
import com.stephanieverissimo.moviesapp.data.repository.MovieRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MovieViewModel(repository: MovieRepository) : ViewModel() {

    val movies = repository.getMovies(BuildConfig.API_KEY).cachedIn(viewModelScope)
    val error = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            movies.catch { e ->
                when (e) {
                    is IOException -> error.postValue("Network Error")
                    is HttpException -> error.postValue("Server Error")
                    else -> error.postValue("Unknown Error")
                }
            }.cachedIn(viewModelScope)
        }
    }
}
