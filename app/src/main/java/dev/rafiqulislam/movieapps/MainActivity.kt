package dev.rafiqulislam.movieapps

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import dev.rafiqulislam.movieapps.repository.Repository
import dev.rafiqulislam.movieapps.screens.MovieScreen
import dev.rafiqulislam.movieapps.ui.theme.MovieAppsTheme
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel
import dev.rafiqulislam.movieapps.viewModel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // repository
        val repository = Repository(applicationContext)

        // view model factory
        val viewModelFactory = MovieViewModelFactory(repository)

        // view model
        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]
        setContent {
            MovieAppsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Popular Movies",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    },
                    content = { innerPadding ->
                        MovieScreen(
                            viewModel = movieViewModel,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                )


            }
        }
    }
}