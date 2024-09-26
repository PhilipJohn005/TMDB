package com.example.tmdb_client_app.presentation_layer

import android.app.Application
import com.example.tmdb_client_app.BuildConfig
import com.example.tmdb_client_app.presentation_layer.di.core.NetModule
import com.example.tmdb_client_app.presentation_layer.di.core.RemoteDataSourceDependency
import dagger.hilt.android.HiltAndroidApp
import dagger.internal.DaggerGenerated

/*class App:Application(),Injector{
    private lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataSourceDependency(RemoteDataSourceDependency(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvSubComponent(): TvSubComponent {
        return appComponent.tvSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}*/
@HiltAndroidApp
class App : Application()