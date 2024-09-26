package com.example.tmdb_client_app.presentation_layer.tvLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client_app.domain.tv_use_case.GetTvUseCase
import com.example.tmdb_client_app.domain.tv_use_case.UpdateTvUseCase

class TvViewModel(
    private val getTvUseCase: GetTvUseCase,
    private val updateTvUseCase: UpdateTvUseCase
):ViewModel(){

     fun getTv()= liveData {
        val tvList=getTvUseCase.excute()
        emit(tvList)
    }

     fun updateTv()= liveData {
        val tvList=updateTvUseCase.excute()
        emit(tvList)
    }
}