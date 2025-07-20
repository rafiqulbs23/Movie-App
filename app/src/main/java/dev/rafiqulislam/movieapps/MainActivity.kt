package dev.rafiqulislam.movieapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import dev.rafiqulislam.movieapps.repository.Repository
import dev.rafiqulislam.movieapps.screens.MovieScreen
import dev.rafiqulislam.movieapps.ui.theme.MovieAppsTheme
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel
import dev.rafiqulislam.movieapps.viewModel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // repository
        val repository  = Repository()

        // view model factory
        val viewModelFactory = MovieViewModelFactory(repository)

        // view model
        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]
        setContent {
            MovieAppsTheme {
                Column {

                    HeaderComposable()

                    MovieScreen(viewModel = movieViewModel)
                }
            }
        }
    }
}

@Composable
fun HeaderComposable(){

    Column(
        horizontalAlignment =
            Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 12.dp)
    ) {
        Text(
            text = "The Moviz App",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Get Popular Movies",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal

        )

    }


}