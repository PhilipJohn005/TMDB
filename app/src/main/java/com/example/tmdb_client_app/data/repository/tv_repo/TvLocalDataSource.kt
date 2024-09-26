package com.example.tmdb_client_app.data.repository.tv_repo

import com.example.tmdb_client_app.data.model.tvshow.TV

interface TvLocalDataSource {

    suspend fun getTv():List<TV>
    suspend fun saveToDB(tv:List<TV>)
    suspend fun clearAll()
}