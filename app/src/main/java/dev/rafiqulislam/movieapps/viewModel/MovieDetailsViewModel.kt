package dev.rafiqulislam.movieapps.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rafiqulislam.movieapps.dao.MovieDetailsResponse
import dev.rafiqulislam.movieapps.repository.MovieDetailsRepository
import dev.rafiqulislam.movieapps.retrofit.Movie
import dev.rafiqulislam.movieapps.utils.Result
import kotlinx.coroutines.launch

class MovieDetailsViewModel() : ViewModel(){
    private val repository:MovieDetailsRepository = MovieDetailsRepository()
    var movieDetails by mutableStateOf<Result<MovieDetailsResponse>>(Result.Loading)
        private set



    fun loadProductDetails(movieId: Int) {
        viewModelScope.launch {
            movieDetails = Result.Loading
            try {
                val response = repository.getMovieDetails(movieId,"267d6a9d43bff4f2bce565524b331620")
                Log.d("MovieDetailsPoster", "loadProductDetails called with movieId: ${response.title}")
                movieDetails = Result.Success(response)

            } catch (e: Exception) {
                movieDetails = Result.Error(e.message.toString())
            }
        }
    }

}