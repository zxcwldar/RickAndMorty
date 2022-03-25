package com.zxcwldar.rickandmorty.data.repositories

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.zxcwldar.rickandmorty.common.resource.Resource
import com.zxcwldar.rickandmorty.data.remote.apiservices.CharactersApiService
import com.zxcwldar.rickandmorty.data.remote.pagingsources.CharacterPagingSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersApiService: CharactersApiService,
) {
    fun fetchCharacters() = Pager(PagingConfig(pageSize = 20)) {
        CharacterPagingSource(charactersApiService)
    }.flow

    fun fetchSingleCharacter(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())


        try {
            emit(Resource.Success(charactersApiService.fetchSingleCharacter(id)))

        } catch (ioException: Exception) {
            emit(Resource.Error(null, ioException.localizedMessage))
        }
    }

}