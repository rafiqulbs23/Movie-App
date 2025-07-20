package dev.rafiqulislam.movieapps.screens

import androidx.compose.runtime.Composable
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel){

    val moviesList = viewModel.movies
    MovieList(movies = moviesList)



}