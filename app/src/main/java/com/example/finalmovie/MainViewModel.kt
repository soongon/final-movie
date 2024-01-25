package com.example.finalmovie

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalmovie.model.Movie
import com.example.finalmovie.model.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepository = MovieRepository()
): ViewModel() {

    init {
        loadNowPlayingMovies()
        Log.d("tag_movie", "viewModel initiated..")
    }

    // state
    var nowPlayingMovies: List<Movie> by mutableStateOf(emptyList())  // List<Movie>

    fun loadNowPlayingMovies() {

        viewModelScope.launch {
            val state = repository.getNowPlayingMovies().results
            Log.d("tag_movie", state.toString())
            nowPlayingMovies = state
        }

    }
}