package com.example.tmdb_client_app.data.movie_repo.movie

import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.domain.movie_use_case.MovieRepository

class FakeMovieRepository:MovieRepository {
    private val movies= mutableListOf<Movie>()

    init {
        movies.add(Movie(1,"overview1","path1","date1","title1"))
        movies.add(Movie(2,"overview2","path2","date2","title2"))

    }

    override suspend fun getAllMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(5,"overview5","path5","date5","title5"))
        movies.add(Movie(7,"overview7","path7","date7","title7"))
        return movies
    }
}