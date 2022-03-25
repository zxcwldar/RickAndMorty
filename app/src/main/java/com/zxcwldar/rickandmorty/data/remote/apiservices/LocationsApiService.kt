package com.zxcwldar.rickandmorty.data.remote.apiservices

import com.zxcwldar.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.zxcwldar.rickandmorty.data.remote.dtos.location.RickAndMortyLocation
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationsApiService {

    @GET("api/location")
    suspend fun fetchLocations(
        @Query("page") page: Int,
    ): RickAndMortyResponse<RickAndMortyLocation>


}