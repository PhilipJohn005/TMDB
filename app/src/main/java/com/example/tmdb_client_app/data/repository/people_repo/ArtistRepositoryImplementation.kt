package com.example.tmdb_client_app.data.repository.people_repo

import android.util.Log
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.domain.artist_use_case.ArtistRepository
import okhttp3.Response

class ArtistRepositoryImplementation(
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newArtistList=getArtistFromRemoteDB()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }
    suspend fun getArtistFromRemoteDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDataSource.getArtistFromAPI()
            val body = response.body()
            if (body !=null)
                artistList=body.artists
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromLocalDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList=artistLocalDataSource.getArtistFromDB()
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(artistList.size>0)
            return artistList
        else{
            artistList=getArtistFromRemoteDB()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList:List<Artist>

        try {
            artistList=artistCacheDataSource.getArtistFromCache()
        }catch (e:Exception){
            Log.i("MyTag",e.message.toString())
        }
        if(artistList.size>0)
            return artistList
        else{
            artistList=getArtistFromLocalDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}