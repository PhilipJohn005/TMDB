package com.example.tmdb_client_app.data.repository.movie_repo

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.model.movie.MovieList
import retrofit2.Response

//tmdbService is like a DAO for the API
class MovieRemoteDataSourceImplementation(private val tmdbService:TMDBService,private val apiKey:String): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
            return tmdbService.getPopularMovies(apiKey)
    }

}