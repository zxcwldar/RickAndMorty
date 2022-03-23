package com.zxcwldar.rickandmorty.data.remote.dtos.location

import com.google.gson.annotations.SerializedName

data class RickAndMortyLocation(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String
)