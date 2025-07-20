package dev.rafiqulislam.movieapps.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.rafiqulislam.movieapps.retrofit.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase() {

    abstract val moviesDao: MovieDAO

    companion object {

        @Volatile
        private var INSTANCE: MoviesDB? = null


        fun getInstance(context: Context): MoviesDB {

            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {

                    // Creating the DB Object
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        MoviesDB::class.java,
                        "movies_db"
                    ).build()

                }

                INSTANCE = instance

                return instance

            }


        }


    }
}