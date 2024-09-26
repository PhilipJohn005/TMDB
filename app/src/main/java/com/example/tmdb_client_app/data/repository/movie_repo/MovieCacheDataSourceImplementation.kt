package com.example.tmdb_client_app.data.repository.movie_repo

import com.example.tmdb_client_app.data.model.movie.Movie

class MovieCacheDataSourceImplementation: MovieCacheDataSource {
    private var movieList:ArrayList<Movie> =ArrayList()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList=ArrayList(movies)   //A new arraylist with movies is assigned to movieList
    }
}