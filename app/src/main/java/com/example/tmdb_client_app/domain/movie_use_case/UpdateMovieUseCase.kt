package com.example.tmdb_client_app.domain.movie_use_case

import com.example.tmdb_client_app.data.model.movie.Movie

class UpdateMovieUseCase(private val movieRepository: MovieRepository){

    suspend fun execute():List<Movie>?=movieRepository.updateMovies()
}