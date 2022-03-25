package com.zxcwldar.rickandmorty.data.remote.apiservices

import com.zxcwldar.rickandmorty.data.remote.dtos.RickAndMortyResponse
import com.zxcwldar.rickandmorty.data.remote.dtos.character.RickAndMortyCharacter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApiService {

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
    ): RickAndMortyResponse<RickAndMortyCharacter>

    @GET("api/character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): RickAndMortyCharacter
}