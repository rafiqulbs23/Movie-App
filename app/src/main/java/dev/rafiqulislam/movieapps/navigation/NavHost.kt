package dev.rafiqulislam.movieapps.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.rafiqulislam.movieapps.repository.MovieDetailsRepository
import dev.rafiqulislam.movieapps.screens.MovieDetailsContent
import dev.rafiqulislam.movieapps.screens.MovieDetailsScreen
import dev.rafiqulislam.movieapps.screens.MovieScreen
import dev.rafiqulislam.movieapps.ui.theme.MovieAppsTheme
import dev.rafiqulislam.movieapps.viewModel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
    movieViewModel: MovieViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route
    ) {
        composable(Screen.MovieList.route) {
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
                            modifier = Modifier.padding(innerPadding),
                            navController= navController
                        )
                    }
                )


            }
        }

        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            MovieDetailsScreen(
                movieId = movieId,
                onBackClick = { navController.navigateUp() },
            )
        }
    }
}
