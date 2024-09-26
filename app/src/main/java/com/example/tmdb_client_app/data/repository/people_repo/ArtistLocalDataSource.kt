package com.example.tmdb_client_app.data.repository.people_repo

import com.example.tmdb_client_app.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun getArtistFromDB():List<Artist>
    suspend fun clearAll()
}