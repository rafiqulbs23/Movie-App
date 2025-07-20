package dev.rafiqulislam.movieapps.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dev.rafiqulislam.movieapps.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>){

    LazyColumn {
        items(movies){
            movie -> MovieItem(movie)
        }
    }

}