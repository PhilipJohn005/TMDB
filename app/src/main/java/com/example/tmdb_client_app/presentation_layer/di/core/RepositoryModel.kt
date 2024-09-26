package com.example.tmdb_client_app.presentation_layer.di.core

import com.example.tmdb_client_app.data.repository.movie_repo.MovieCacheDataSource
import com.example.tmdb_client_app.data.repository.movie_repo.MovieLocalDataSource
import com.example.tmdb_client_app.data.repository.movie_repo.MovieRemoteDataSource
import com.example.tmdb_client_app.data.repository.movie_repo.MovieRepositoryImplement
import com.example.tmdb_client_app.data.repository.people_repo.ArtistCacheDataSource
import com.example.tmdb_client_app.data.repository.people_repo.ArtistLocalDataSource
import com.example.tmdb_client_app.data.repository.people_repo.ArtistRemoteDataSource
import com.example.tmdb_client_app.data.repository.people_repo.ArtistRepositoryImplementation
import com.example.tmdb_client_app.data.repository.tv_repo.TvCacheDataSource
import com.example.tmdb_client_app.data.repository.tv_repo.TvLocalDataSource
import com.example.tmdb_client_app.data.repository.tv_repo.TvRemoteDataSource
import com.example.tmdb_client_app.data.repository.tv_repo.TvRepositoryImplementation
import com.example.tmdb_client_app.domain.artist_use_case.ArtistRepository
import com.example.tmdb_client_app.domain.movie_use_case.MovieRepository
import com.example.tmdb_client_app.domain.tv_use_case.TvRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModel {

    @Provides
    @Singleton
    fun provideMovieRepositoryDependency(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ):MovieRepository{
        return MovieRepositoryImplement(movieRemoteDataSource,movieLocalDataSource,movieCacheDataSource)
    }

    @Provides
    @Singleton
    fun provideTvRepositoryDependency(
        tvRemoteDataSource: TvRemoteDataSource,
        tvLocalDataSource: TvLocalDataSource,
        tvCacheDataSource: TvCacheDataSource
    ):TvRepository{
        return TvRepositoryImplementation(tvCacheDataSource,tvLocalDataSource,tvRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideArtistRepositoryDependency(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ):ArtistRepository{
        return ArtistRepositoryImplementation(artistLocalDataSource,artistRemoteDataSource,artistCacheDataSource)
    }
}