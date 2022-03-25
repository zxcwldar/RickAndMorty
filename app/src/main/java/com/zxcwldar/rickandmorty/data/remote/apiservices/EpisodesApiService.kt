package com.zxcwldar.rickandmorty.data.remote.apiservices


import com.zxcwldar.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.zxcwldar.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodesApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page: Int,
    ): RickAndMortyResponse<RickAndMortyEpisode>


}