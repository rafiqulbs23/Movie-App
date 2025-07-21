package dev.rafiqulislam.movieapps.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import dev.rafiqulislam.movieapps.repository.MovieDetailsRepository
import dev.rafiqulislam.movieapps.viewModel.MovieDetailsViewModel
import dev.rafiqulislam.movieapps.utils.Result
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun MovieDetailsScreen(
    movieId: Int,
        onBackClick: () -> Unit,
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text(text = "Product Details") },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }

                )
            }
        ) { padding ->
            MovieDetailsContent(
                movieId = movieId,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            )
        }
    }


@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun MovieDetailsContent(
    movieId: Int,
    modifier: Modifier
) {
    val viewModel = remember { MovieDetailsViewModel() }

    LaunchedEffect(movieId) {
        viewModel.loadProductDetails(movieId)
    }

    when (val result = viewModel.movieDetails) {
        is Result.Loading -> MovieLoadingScreen()
        is Result.Success -> {
            Surface(
                modifier = modifier,
                color = MaterialTheme.colorScheme.background
            ) {
                Column(modifier= Modifier.fillMaxSize()) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500/${result.data.poster_path}",
                        contentDescription ="Movie Image",
                        modifier = Modifier.clip(RoundedCornerShape(16.dp))
                            .fillMaxWidth()
                            .height(400.dp) ,
                        contentScale = ContentScale.FillWidth

                    )


                    Spacer(modifier = Modifier.width(8.dp))

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = result.data.title, fontSize = 30.sp, style = MaterialTheme.typography.bodyLarge)
                        Text(text = result.data.overview, fontSize = 20.sp,  style = MaterialTheme.typography.bodySmall)
                    }
                }
            }

        }
        is Result.Error -> {
            Text("Error: ${result.message ?: "An error occurred"}")
        }
    }
}



@Composable
fun MovieDetailsLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MovieDetailsErrorScreen(viewModel: MovieDetailsViewModel, errorMessage: String, movieId: Int,) {
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
                viewModel.loadProductDetails(movieId)
            },
        ) {
            Text(text = "Retry")
        }
    }

}