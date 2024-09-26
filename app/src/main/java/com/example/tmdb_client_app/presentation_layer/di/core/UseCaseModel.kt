package com.example.tmdb_client_app.presentation_layer.di.core

import com.example.tmdb_client_app.domain.artist_use_case.ArtistRepository
import com.example.tmdb_client_app.domain.artist_use_case.GetArtistUseCase
import com.example.tmdb_client_app.domain.artist_use_case.UpdateArtistUseCase
import com.example.tmdb_client_app.domain.movie_use_case.GetMoviesUseCase
import com.example.tmdb_client_app.domain.movie_use_case.MovieRepository
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase
import com.example.tmdb_client_app.domain.tv_use_case.GetTvUseCase
import com.example.tmdb_client_app.domain.tv_use_case.TvRepository
import com.example.tmdb_client_app.domain.tv_use_case.UpdateTvUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModel {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }
    @Singleton
    @Provides
    fun provideGetTvUseCase(tvRepository: TvRepository):GetTvUseCase{
        return GetTvUseCase(tvRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateTvUseCase(tvRepository: TvRepository):UpdateTvUseCase{
        return UpdateTvUseCase(tvRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }




}