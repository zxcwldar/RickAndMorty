package com.zxcwldar.rickandmorty.presentation.ui.fragments.character


import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.zxcwldar.rickandmorty.base.BaseViewModel
import com.zxcwldar.rickandmorty.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {


    fun fetchCharacters() =
        characterRepository.fetchCharacters().cachedIn(viewModelScope)


}

