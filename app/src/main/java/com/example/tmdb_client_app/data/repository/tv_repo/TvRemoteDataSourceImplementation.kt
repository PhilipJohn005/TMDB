package com.example.tmdb_client_app.data.repository.tv_repo

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.model.tvshow.TVList
import retrofit2.Response

class TvRemoteDataSourceImplementation(private val tmdbService: TMDBService,private val apiKey:String):TvRemoteDataSource {
    override suspend fun getTv(): Response<TVList> {
        return tmdbService.getPopularTv(apiKey)
    }
}