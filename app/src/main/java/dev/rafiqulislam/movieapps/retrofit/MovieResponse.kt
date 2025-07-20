package dev.rafiqulislam.movieapps.retrofit

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    val pages: Int,
    val results : List<Movie>,

    @SerializedName("total_pages")
    val totalPages: Int,

    val total_results: Int

)