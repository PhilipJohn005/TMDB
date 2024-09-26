package com.example.tmdb_client_app.domain.artist_use_case

import com.example.tmdb_client_app.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}