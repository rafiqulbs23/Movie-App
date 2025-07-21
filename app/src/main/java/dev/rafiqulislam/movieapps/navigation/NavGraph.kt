package dev.rafiqulislam.movieapps.navigation

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object MovieDetails : Screen("movie_details/{movieId}") {
        fun createRoute(movieId: Int) = "movie_details/$movieId"
    }
}
