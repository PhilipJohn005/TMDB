package com.example.tmdb_client_app.presentation_layer.artistLayer

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client_app.domain.artist_use_case.GetArtistUseCase
import com.example.tmdb_client_app.domain.artist_use_case.UpdateArtistUseCase
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModel() {

    fun getArtist()= liveData {
        val artistList=getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist()= liveData {
        val artistList=updateArtistUseCase.execute()
        emit(artistList)
    }
}