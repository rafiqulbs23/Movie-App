package dev.rafiqulislam.movieapps.repository

import android.content.Context
import dev.rafiqulislam.movieapps.dao.MovieDAO
import dev.rafiqulislam.movieapps.dao.MoviesDB
import dev.rafiqulislam.movieapps.retrofit.Movie
import dev.rafiqulislam.movieapps.retrofit.RetrofitInstance

class Repository(private val context: Context) {

    suspend fun getPopularMovies(apiKey: String):List<Movie>{
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    // Fetching data from Offline ROOM Database
    private val db = MoviesDB.getInstance(context)
    private val movieDao : MovieDAO = db.moviesDao


    suspend fun getMoviesFromDB(): List<Movie>{
        return movieDao.getAllMoviesInDB()
    }


    suspend fun insertMoviesIntoDB(movies:List<Movie>){
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie: Movie){
        return movieDao.insert(movie)
    }
}