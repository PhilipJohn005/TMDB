package com.example.tmdb_client_app.data.repository.people_repo

import com.example.tmdb_client_app.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun saveArtistToCache(artist: List<Artist>)
    suspend fun getArtistFromCache():List<Artist>
}