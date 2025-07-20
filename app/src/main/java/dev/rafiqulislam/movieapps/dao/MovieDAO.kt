package dev.rafiqulislam.movieapps.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.rafiqulislam.movieapps.retrofit.Movie

@Dao
interface MovieDAO {

    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMoviesInDB(): List<Movie>

}