package com.example.tmdb_client_app.data.repository.people_repo

import com.example.tmdb_client_app.data.model.artist.Artist

class ArtistCacheDataSourceImplementation:ArtistCacheDataSource{
    private var artistList=ArrayList<Artist>()
    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList= ArrayList(artist)
    }

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }
}