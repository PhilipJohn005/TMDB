package com.example.tmdb_client_app.domain.movie_use_case

import com.example.tmdb_client_app.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun excute():List<Movie>?=movieRepository.getAllMovies()
}