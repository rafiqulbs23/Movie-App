package dev.rafiqulislam.movieapps
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import dev.rafiqulislam.movieapps.navigation.AppNavHost
import dev.rafiqulislam.movieapps.repository.Repository
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel
import dev.rafiqulislam.movieapps.viewModel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
            val navController = rememberNavController()
            AppNavHost(
                navController = navController,
                movieViewModel = movieViewModel
            )

        }
    }
}