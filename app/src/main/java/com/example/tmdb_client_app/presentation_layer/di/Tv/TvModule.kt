package com.example.tmdb_client_app.presentation_layer.di.Tv

import com.example.tmdb_client_app.domain.tv_use_case.GetTvUseCase
import com.example.tmdb_client_app.domain.tv_use_case.UpdateTvUseCase
import com.example.tmdb_client_app.presentation_layer.tvLayer.TvViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class TvModule {
    @ActivityScoped
    @Provides
    fun provideTvViewModelFactory(getTvUseCase: GetTvUseCase,updateTvUseCase: UpdateTvUseCase):TvViewModelFactory{
        return TvViewModelFactory(getTvUseCase,updateTvUseCase)
    }
}