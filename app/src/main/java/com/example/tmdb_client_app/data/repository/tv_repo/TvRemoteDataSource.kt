package com.example.tmdb_client_app.data.repository.tv_repo

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.model.movie.MovieList
import com.example.tmdb_client_app.data.model.tvshow.TVList
import retrofit2.Response


interface TvRemoteDataSource {
    suspend fun getTv(): Response<TVList>
}