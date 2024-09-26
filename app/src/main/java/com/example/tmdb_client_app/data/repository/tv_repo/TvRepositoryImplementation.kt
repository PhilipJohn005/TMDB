package com.example.tmdb_client_app.data.repository.tv_repo

import android.util.Log
import com.example.tmdb_client_app.data.model.tvshow.TV
import com.example.tmdb_client_app.data.model.tvshow.TVList
import com.example.tmdb_client_app.domain.tv_use_case.TvRepository

class TvRepositoryImplementation(
    private val tvCacheDataSource: TvCacheDataSource,
    private val tvLocalDataSource: TvLocalDataSource,
    private val tvRemoteDataSource: TvRemoteDataSource
):TvRepository {
    override suspend fun getTv(): List<TV>? {
        return getTvFromCache()
    }

    override suspend fun updateTv(): List<TV>? {
        val newListOfTv=getTvFromRemoteDB()
        tvLocalDataSource.clearAll()
        tvLocalDataSource.saveToDB(newListOfTv)
        tvCacheDataSource.saveTvToCache(newListOfTv)
        return newListOfTv

    }
    suspend fun getTvFromLocalDB():List<TV>{
        lateinit var tvList:List<TV>
        try {
            tvList=tvLocalDataSource.getTv()
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(tvList.size>0)
            return tvList
        else{
            tvList=getTvFromRemoteDB()
            tvLocalDataSource.saveToDB(tvList)
        }
        return tvList
    }

    suspend fun getTvFromRemoteDB():List<TV>{
        lateinit var tvList:List<TV>
        try{
            val response=tvRemoteDataSource.getTv()
            val body=response.body()
            if(body!=null)
                    tvList=body.TVS
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return tvList
    }

    suspend fun getTvFromCache():List<TV>{
        lateinit var tvList: List<TV>
        try {
            tvList=tvCacheDataSource.getTvFromCache()
        }catch (e:Exception){
            Log.i("Mytag",e.message.toString())
        }
        if(tvList.size>0)
            return tvList
        else{
            tvList=getTvFromLocalDB()
            tvCacheDataSource.saveTvToCache(tvList)
        }
        return tvList
    }
}