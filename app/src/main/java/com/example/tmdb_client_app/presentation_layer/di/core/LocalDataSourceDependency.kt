package com.example.tmdb_client_app.presentation_layer.di.core

import com.example.tmdb_client_app.data.db.MovieDAO
import com.example.tmdb_client_app.data.db.PersonDAO
import com.example.tmdb_client_app.data.db.TvDAO
import com.example.tmdb_client_app.data.repository.movie_repo.MovieLocalDataSource
import com.example.tmdb_client_app.data.repository.movie_repo.MovieLocalDataSourceImplementation
import com.example.tmdb_client_app.data.repository.people_repo.ArtistLocalDataSource
import com.example.tmdb_client_app.data.repository.people_repo.ArtistLocalDataSourceImplementation
import com.example.tmdb_client_app.data.repository.tv_repo.TvLocalDataSource
import com.example.tmdb_client_app.data.repository.tv_repo.TvLocalDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceDependency {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO):MovieLocalDataSource{
        return MovieLocalDataSourceImplementation(movieDAO)
    }
    @Singleton
    @Provides
    fun provideTvLocalDataSource(tvDAO: TvDAO):TvLocalDataSource{
        return TvLocalDataSourceImplementation(tvDAO)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(personDAO: PersonDAO):ArtistLocalDataSource{
        return ArtistLocalDataSourceImplementation(personDAO)
    }
}