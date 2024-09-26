package com.example.tmdb_client_app.domain.artist_use_case

import com.example.tmdb_client_app.data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute():List<Artist>?=artistRepository.updateArtist()

}