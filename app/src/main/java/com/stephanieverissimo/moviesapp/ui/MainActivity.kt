package com.stephanieverissimo.moviesapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.stephanieverissimo.moviesapp.data.RetrofitBuilder
import com.stephanieverissimo.moviesapp.data.repository.MovieRepository
import com.stephanieverissimo.moviesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Criando o ViewModel
        val repository = MovieRepository(RetrofitBuilder.movieApi)
        val viewModelFactory = MovieViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieViewModel::class.java)

        // Configurando o RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observando os dados
        lifecycleScope.launch {
            viewModel.movies.collect { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        // Observando erros
        viewModel.error.observe(this) { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
