package com.stephanieverissimo.moviesapp.di

import com.stephanieverissimo.moviesapp.data.RetrofitBuilder
import com.stephanieverissimo.moviesapp.data.repository.MovieRepository
import com.stephanieverissimo.moviesapp.ui.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { RetrofitBuilder.movieApi}
    factory { MovieRepository(get()) }
    viewModel{ MovieViewModel(get())}

}