package com.example.tmdb_client_app.data.repository.tv_repo

import com.example.tmdb_client_app.data.db.TvDAO
import com.example.tmdb_client_app.data.model.tvshow.TV
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class TvLocalDataSourceImplementation(private val tvDAO: TvDAO):TvLocalDataSource {
    override suspend fun getTv(): List<TV> {
        return tvDAO.getAllTV()
    }

    override suspend fun saveToDB(tv: List<TV>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDAO.insertTV(tv)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDAO.deleteTV()
        }
    }


}