package com.example.tmdb_client_app.data.api

import com.example.tmdb_client_app.data.model.artist.ArtistList
import com.example.tmdb_client_app.data.model.movie.MovieList
import com.example.tmdb_client_app.data.model.tvshow.TVList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTv(@Query("api_key")apiKey:String): Response<TVList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")apiKey:String): Response<ArtistList>
}