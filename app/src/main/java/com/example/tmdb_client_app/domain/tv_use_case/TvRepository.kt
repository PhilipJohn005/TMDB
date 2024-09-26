package com.example.tmdb_client_app.domain.tv_use_case

import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.model.tvshow.TV

interface TvRepository {

    suspend fun getTv():List<TV>?
    suspend fun updateTv():List<TV>?
}