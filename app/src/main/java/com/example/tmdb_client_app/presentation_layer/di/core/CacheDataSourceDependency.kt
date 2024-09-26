package com.example.tmdb_client_app.presentation_layer.di.core

import com.example.tmdb_client_app.data.repository.movie_repo.MovieCacheDataSource
import com.example.tmdb_client_app.data.repository.movie_repo.MovieCacheDataSourceImplementation
import com.example.tmdb_client_app.data.repository.people_repo.ArtistCacheDataSource
import com.example.tmdb_client_app.data.repository.people_repo.ArtistCacheDataSourceImplementation
import com.example.tmdb_client_app.data.repository.tv_repo.TvCacheDataSource
import com.example.tmdb_client_app.data.repository.tv_repo.TvCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CacheDataSourceDependency {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImplementation()
    }

    @Singleton
    @Provides
    fun provideTvCacheDataSource(): TvCacheDataSource {
        return TvCacheDataSourceImplementation()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImplementation()
    }
}