package com.example.tmdb_client_app.domain.tv_use_case

import com.example.tmdb_client_app.data.model.tvshow.TV

class UpdateTvUseCase(private val tvRepository: TvRepository) {

    suspend fun excute():List<TV>?=tvRepository.updateTv()
}