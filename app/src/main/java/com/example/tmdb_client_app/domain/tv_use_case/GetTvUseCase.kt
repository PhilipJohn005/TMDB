package com.example.tmdb_client_app.domain.tv_use_case

import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.model.tvshow.TV

class GetTvUseCase(private val tvRepository: TvRepository) {

    suspend fun excute():List<TV>?=tvRepository.getTv()
}