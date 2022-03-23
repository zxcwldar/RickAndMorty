package com.zxcwldar.rickandmorty.presentation.ui.fragments.episode

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentEpisodesBinding
import com.zxcwldar.rickandmorty.base.BaseFragment
import com.zxcwldar.rickandmorty.common.resource.Resource
import com.zxcwldar.rickandmorty.presentation.ui.adapters.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodesFragment :
    BaseFragment<FragmentEpisodesBinding, EpisodeViewModel>(R.layout.fragment_episodes) {
    override val binding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val adapter = EpisodesAdapter()
    override fun setupViews() {
        setupAdapter()

    }


    private fun setupAdapter() {
        binding.recyclerview.adapter = adapter
    }


    override fun setupObserver() {
        subscribeToEpisodes()
    }

    private fun subscribeToEpisodes() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchEpisodes().observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("anime", "Loading ")
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