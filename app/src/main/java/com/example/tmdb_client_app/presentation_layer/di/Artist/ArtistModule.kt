package com.example.tmdb_client_app.presentation_layer.di.Artist

import com.example.tmdb_client_app.domain.artist_use_case.GetArtistUseCase
import com.example.tmdb_client_app.domain.artist_use_case.UpdateArtistUseCase
import com.example.tmdb_client_app.presentation_layer.artistLayer.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

//Provides the dependency
@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {
    @ActivityScoped  //ties it to scope
    @Provides
    fun provideArtistViewModelFactory(getArtistUseCase: GetArtistUseCase,updateArtistUseCase: UpdateArtistUseCase):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase,updateArtistUseCase)
    }
}