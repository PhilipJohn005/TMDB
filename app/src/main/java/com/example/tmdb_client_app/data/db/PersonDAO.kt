package com.example.tmdb_client_app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_client_app.data.model.artist.Artist

@Dao
interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtist(person:List<Artist>)

    @Query("DELETE FROM popular_artist")
    suspend fun deleteArtist()

    @Query("SELECT * FROM popular_artist")
    suspend fun getAllArtist():List<Artist>
}