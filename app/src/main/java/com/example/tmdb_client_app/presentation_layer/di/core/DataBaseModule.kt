package com.example.tmdb_client_app.presentation_layer.di.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tmdb_client_app.data.db.MovieDAO
import com.example.tmdb_client_app.data.db.PersonDAO
import com.example.tmdb_client_app.data.db.TMDBDatabase
import com.example.tmdb_client_app.data.db.TvDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(App:Application):TMDBDatabase{
        return Room.databaseBuilder(App,TMDBDatabase::class.java,"tmdbclient").build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDAO()
    }
    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvDAO {
        return tmdbDatabase.tvDAO()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): PersonDAO {
        return tmdbDatabase.artistDAO()
    }
}