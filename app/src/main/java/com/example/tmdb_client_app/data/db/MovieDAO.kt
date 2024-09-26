package com.example.tmdb_client_app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_client_app.data.model.movie.Movie

@Dao
interface MovieDAO {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies:List<Movie>)

    @Query("delete from popular_movies")
    suspend fun deleteMovies()

    @Query("select * from popular_movies")
    suspend fun getAllMovies():List<Movie>
}