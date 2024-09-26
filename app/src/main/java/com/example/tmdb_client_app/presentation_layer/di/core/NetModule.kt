package com.example.tmdb_client_app.presentation_layer.di.core

import com.example.tmdb_client_app.BuildConfig
import com.example.tmdb_client_app.data.api.TMDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Singleton  //single retrofit dependency throught the operation of the app
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{                        //to get data starting we need tmdb instance...we get tmdb instance by first making retrofit instance
        return retrofit.create(TMDBService::class.java)
    }
}