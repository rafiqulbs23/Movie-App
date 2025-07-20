package dev.rafiqulislam.movieapps.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class Movie(

    @PrimaryKey
    val id: Int,

    val title : String,

    val overview: String,
    val poster_path : String

)