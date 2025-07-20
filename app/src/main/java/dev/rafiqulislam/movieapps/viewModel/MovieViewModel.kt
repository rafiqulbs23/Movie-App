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
                moviesFromApi = repository.getPopularMovies("YOUR_API_KEY_HERE")
                movies = moviesFromApi
            } catch (e: Exception) {

            }
        }
    }



}