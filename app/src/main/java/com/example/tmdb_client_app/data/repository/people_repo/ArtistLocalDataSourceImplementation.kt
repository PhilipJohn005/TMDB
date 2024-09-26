package com.example.tmdb_client_app.data.repository.people_repo

import com.example.tmdb_client_app.data.db.PersonDAO
import com.example.tmdb_client_app.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImplementation(private val artistDAO: PersonDAO):ArtistLocalDataSource {
    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.insertArtist(artist)
        }
    }

    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDAO.getAllArtist()
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteArtist()
        }
    }
}