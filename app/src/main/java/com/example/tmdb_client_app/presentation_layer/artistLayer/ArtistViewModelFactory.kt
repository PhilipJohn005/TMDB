package com.example.tmdb_client_app.presentation_layer.artistLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_client_app.domain.artist_use_case.GetArtistUseCase
import com.example.tmdb_client_app.domain.artist_use_case.UpdateArtistUseCase
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase,updateArtistUseCase) as T
    }
}