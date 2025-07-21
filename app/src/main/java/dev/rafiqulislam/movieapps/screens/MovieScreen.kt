package dev.rafiqulislam.movieapps.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel, modifier: Modifier,){

        viewModel.movies.let { result ->
            when (result) {
                is dev.rafiqulislam.movieapps.utils.Result.Loading -> MovieLoadingScreen()
                is dev.rafiqulislam.movieapps.utils.Result.Success -> MovieList(movies = result.data,modifier)
                is dev.rafiqulislam.movieapps.utils.Result.Error -> MovieErrorScreen(
                    viewModel = viewModel,
                    errorMessage = result.message,
                )
            }
    }


    }



@Composable
fun MovieLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MovieErrorScreen(viewModel: MovieViewModel, errorMessage: String,) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Text(text = "${errorMessage}", style = MaterialTheme.typography.bodyLarge)

        Button (
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            onClick = {
                viewModel.reload()
            },
        ) {
            Text(text = "Retry")
        }
    }

}