package com.zxcwldar.rickandmorty.presentation.ui.fragments.location
import com.zxcwldar.rickandmorty.base.BaseViewModel
import com.zxcwldar.rickandmorty.data.repositories.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationsRepository: LocationsRepository
) : BaseViewModel() {
    fun fetchLocations() = locationsRepository.fetchLocations()
}