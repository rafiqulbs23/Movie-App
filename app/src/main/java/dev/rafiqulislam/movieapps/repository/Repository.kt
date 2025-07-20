package dev.rafiqulislam.movieapps.repository

import dev.rafiqulislam.movieapps.retrofit.Movie
import dev.rafiqulislam.movieapps.retrofit.RetrofitInstance

class Repository {

    suspend fun getPopularMovies(apiKey: String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}