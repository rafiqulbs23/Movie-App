package dev.rafiqulislam.movieapps.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.rafiqulislam.movieapps.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>, modifier: Modifier){

    if (movies.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No movies available.")
        }
    } else {
        LazyColumn(modifier = modifier) {
            items(movies) { movie ->
                MovieItem(movie)
            }
        }
    }
}