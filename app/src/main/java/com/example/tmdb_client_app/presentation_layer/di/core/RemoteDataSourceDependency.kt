package com.example.tmdb_client_app.presentation_layer.di.core

import com.example.tmdb_client_app.BuildConfig
import com.example.tmdb_client_app.data.api.TMDBService
import com.example.tmdb_client_app.data.repository.movie_repo.MovieRemoteDataSource
import com.example.tmdb_client_app.data.repository.movie_repo.MovieRemoteDataSourceImplementation
import com.example.tmdb_client_app.data.repository.people_repo.ArtistRemoteDataSource
import com.example.tmdb_client_app.data.repository.people_repo.ArtistRemoteDataSourceImplementation
import com.example.tmdb_client_app.data.repository.tv_repo.TvRemoteDataSource
import com.example.tmdb_client_app.data.repository.tv_repo.TvRemoteDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceDependency{

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImplementation(
            tmdbService,BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImplementation(
            tmdbService,BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService):TvRemoteDataSource{
        return TvRemoteDataSourceImplementation(
            tmdbService,BuildConfig.API_KEY
        )
    }
}