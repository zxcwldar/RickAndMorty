package com.zxcwldar.rickandmorty.presentation.ui.fragments.episode

import com.zxcwldar.rickandmorty.base.BaseViewModel
import com.zxcwldar.rickandmorty.data.repositories.EpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodesRepository: EpisodesRepository
) : BaseViewModel() {
    fun fetchEpisodes() = episodesRepository.fetchEpisodes()
}