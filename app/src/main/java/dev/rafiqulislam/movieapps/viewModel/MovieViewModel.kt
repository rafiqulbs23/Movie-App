package dev.rafiqulislam.movieapps.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rafiqulislam.movieapps.repository.Repository
import dev.rafiqulislam.movieapps.retrofit.Movie
import kotlinx.coroutines.launch
import dev.rafiqulislam.movieapps.utils.Result

class MovieViewModel(private val repository:Repository):ViewModel() {

    var movies by mutableStateOf< Result<List<Movie>>>(Result.Loading)
    private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
    private set

    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            movies = Result.Loading
            try {
                moviesFromApi = repository.getPopularMovies("267d6a9d43bff4f2bce565524b331620")
                movies = Result.Success(moviesFromApi)
                repository.insertMoviesIntoDB(moviesFromApi)

            } catch (e: Exception) {
                moviesFromRoomDB= repository.getMoviesFromDB()

                movies = Result.Success(moviesFromRoomDB)
            }
        }
    }

    fun reload() {
        viewModelScope.launch {
            movies = Result.Loading
            try {
                moviesFromApi = repository.getPopularMovies("267d6a9d43bff4f2bce565524b331620")
                movies = Result.Success(moviesFromApi)

                repository.insertMoviesIntoDB(moviesFromApi)
            } catch (e: Exception) {
                moviesFromRoomDB = repository.getMoviesFromDB()

                movies = Result.Success(moviesFromRoomDB)
            }
        }
    }




}