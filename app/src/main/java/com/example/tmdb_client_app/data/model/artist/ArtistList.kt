package com.example.tmdb_client_app.data.model.artist


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>,
)