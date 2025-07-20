package dev.rafiqulislam.movieapps.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rafiqulislam.movieapps.repository.Repository
import dev.rafiqulislam.movieapps.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository:Repository):ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
    private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
    private set

    init {
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getPopularMovies("267d6a9d43bff4f2bce565524b331620")
                movies = moviesFromApi
            } catch (e: Exception) {

            }
        }
    }



}