package com.example.tmdb_client_app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb_client_app.data.model.tvshow.TV

@Dao
interface TvDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTV(tv:List<TV>)

    @Query("DELETE FROM popular_tv")
    suspend fun deleteTV()

    @Query("SELECT * FROM popular_tv")
    suspend fun getAllTV():List<TV>
}