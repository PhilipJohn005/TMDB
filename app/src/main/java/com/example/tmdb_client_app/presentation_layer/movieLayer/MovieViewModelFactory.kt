package com.example.tmdb_client_app.presentation_layer.movieLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.tmdb_client_app.domain.movie_use_case.GetMoviesUseCase
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return MovieViewModel(getMoviesUseCase,updateMovieUseCase) as T
    }




}