package com.example.tmdb_client_app.data.repository.tv_repo

import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.model.tvshow.TV
import com.example.tmdb_client_app.data.model.tvshow.TVList

interface TvCacheDataSource {
    suspend fun getTvFromCache():List<TV>
    suspend fun saveTvToCache(tv: List<TV>)
}