package com.example.tmdb_client_app.domain.movie_use_case

import com.example.tmdb_client_app.data.model.movie.Movie

interface MovieRepository {

    suspend fun getAllMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}