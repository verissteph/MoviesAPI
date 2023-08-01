package com.stephanieverissimo.moviesapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stephanieverissimo.moviesapp.databinding.ListMovieItemBinding
import com.stephanieverissimo.moviesapp.model.Movie


class MovieAdapter : PagingDataAdapter<Movie, MovieAdapter.MovieViewHolder>(MOVIE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bindMovie(it) }
    }

    class MovieViewHolder(private val binding: ListMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindMovie(movie: Movie) {
            binding.tvTitle.text = movie.title
            binding.tvOverview.text = movie.overview
            binding.tvVote.text = movie.voteAverange.toString()
            binding.tvReleaseDate.text = movie.releaseDate
            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                .into(binding.ivPoster)
        }
    }

    companion object {
        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem == newItem
        }
    }
}
