package dev.rafiqulislam.movieapps.dao

data class MovieDetailsResponse (
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: BelongsToCollection,
    val budget: Long,
    val genres: List<Genre>,
    val homepage: String,
    val id: Long,
    val imdbID: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Long,
    val runtime: Long,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long
)

data class BelongsToCollection (
    val id: Long,
    val name: String,
    val posterPath: Any? = null,
    val backdropPath: String
)

data class Genre (
    val id: Long,
    val name: String
)

data class ProductionCompany (
    val id: Long,
    val logoPath: String,
    val name: String,
    val originCountry: String
)

data class ProductionCountry (
    val iso3166_1: String,
    val name: String
)

data class SpokenLanguage (
    val englishName: String,
    val iso639_1: String,
    val name: String
)

