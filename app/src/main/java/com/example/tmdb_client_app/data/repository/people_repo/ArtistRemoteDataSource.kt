package com.example.tmdb_client_app.data.repository.people_repo

import com.example.tmdb_client_app.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistFromAPI():Response<ArtistList>
}