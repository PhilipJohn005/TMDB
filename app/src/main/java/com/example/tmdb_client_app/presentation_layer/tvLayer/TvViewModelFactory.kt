package com.example.tmdb_client_app.presentation_layer.tvLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb_client_app.domain.tv_use_case.GetTvUseCase
import com.example.tmdb_client_app.domain.tv_use_case.UpdateTvUseCase

class TvViewModelFactory(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvUseCase: UpdateTvUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvUseCase,updateTvUseCase)as T
    }
}