package com.zxcwldar.rickandmorty.data.remote.apiservices

import com.zxcwldar.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.zxcwldar.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET

interface LocationsApiService {

    @GET("api/location")
    suspend fun fetchEpisode(): RickAndMortyResponse<RickAndMortyLocation>
}