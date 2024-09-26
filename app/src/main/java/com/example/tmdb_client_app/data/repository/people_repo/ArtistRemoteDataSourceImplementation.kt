package com.example.tmdb_client_app.data.repository.people_repo

import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImplementation(private val tmdbService: TMDBService,private val apiKey:String):ArtistRemoteDataSource {
    override suspend fun getArtistFromAPI(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}