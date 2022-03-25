package com.zxcwldar.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.zxcwldar.rickandmorty.data.remote.apiservices.EpisodesApiService
import com.zxcwldar.rickandmorty.data.remote.pagingsources.EpisodePagingSource
import javax.inject.Inject

class EpisodesRepository @Inject constructor(
    private val episodesApiService: EpisodesApiService
) {
    fun fetchEpisodes() = Pager(
        PagingConfig(pageSize = 20)
    ) {
        EpisodePagingSource(episodesApiService)
    }.flow


}
