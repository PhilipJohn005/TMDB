package com.example.tmdb_client_app.data.repository.tv_repo

import com.example.tmdb_client_app.data.model.tvshow.TV

class TvCacheDataSourceImplementation:TvCacheDataSource {
    private var tvList=ArrayList<TV>()
    override suspend fun getTvFromCache(): List<TV> {
        return tvList
    }

    override suspend fun saveTvToCache(tv: List<TV>) {
        tvList.clear()
        tvList=ArrayList(tv)
    }
}