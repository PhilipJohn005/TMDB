package com.example.tmdb_client_app.presentation_layer.di.movie

import com.example.tmdb_client_app.domain.movie_use_case.GetMoviesUseCase
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase
import com.example.tmdb_client_app.presentation_layer.movieLayer.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {
    @ActivityScoped
    @Provides
    fun provideMovieViewModelFactor(getMoviesUseCase: GetMoviesUseCase,updateMovieUseCase: UpdateMovieUseCase):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase,updateMovieUseCase)
    }
}