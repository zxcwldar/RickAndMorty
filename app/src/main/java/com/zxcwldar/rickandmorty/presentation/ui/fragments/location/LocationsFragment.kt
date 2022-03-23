package com.zxcwldar.rickandmorty.presentation.ui.fragments.location

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentLocationsBinding
import com.zxcwldar.rickandmorty.base.BaseFragment
import com.zxcwldar.rickandmorty.common.resource.Resource
import com.zxcwldar.rickandmorty.presentation.ui.adapters.LocationsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationViewModel>(
    R.layout.fragment_locations
) {
    override val viewModel: LocationViewModel by viewModels()
    override val binding by viewBinding(FragmentLocationsBinding::bind)
    private val adapter = LocationsAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {

        binding.recyclerview.adapter = adapter
    }

    override fun setupObserver() {
        subscribeToLocations()
    }

    private fun subscribeToLocations() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchLocations().observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("anime", "loading: ")
                    }
                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())
                    }
                    is Resource.Success -> {
                        it.data?.results?.let { it1 -> adapter.setList(it1) }

                    }

                }
            }
        }
    }
}