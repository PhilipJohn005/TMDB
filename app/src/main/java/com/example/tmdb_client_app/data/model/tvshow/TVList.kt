package com.example.tmdb_client_app.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TVList(

    @SerializedName("results")
    val TVS: List<TV>,

    )