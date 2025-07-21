package dev.rafiqulislam.movieapps.repository
import android.util.Log
import dev.rafiqulislam.movieapps.dao.MovieDetailsResponse
import dev.rafiqulislam.movieapps.retrofit.Movie
import dev.rafiqulislam.movieapps.retrofit.RetrofitInstance

class MovieDetailsRepository {

    suspend fun getMovieDetails(movieId: Int,apiKey: String,): MovieDetailsResponse {
        Log.d("ProductDetailsRepository", "getProductDetails called with productID: $movieId and apiKey: $apiKey")
        return RetrofitInstance.api.getMovieDetails(movieId = movieId, apiKey = apiKey)
    }
}