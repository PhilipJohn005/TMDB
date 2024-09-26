package com.example.tmdb_client_app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.model.tvshow.TV


@Database(entities = [Movie::class, TV::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase:RoomDatabase() {

    abstract fun movieDAO(): MovieDAO
    abstract fun artistDAO(): PersonDAO
    abstract fun tvDAO(): TvDAO


}