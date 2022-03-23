package com.zxcwldar.rickandmorty.presentation.ui.fragments.character

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharactersBinding
import com.zxcwldar.rickandmorty.base.BaseFragment
import com.zxcwldar.rickandmorty.common.resource.Resource
import com.zxcwldar.rickandmorty.presentation.ui.adapters.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(
    R.layout.fragment_characters
) {
    override val binding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharactersAdapter(this::onItemClick)

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recyclerview.adapter = characterAdapter
    }


    override fun setupObserver() {
        subscribeToCharacters()
    }

    private fun subscribeToCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchCharacters().observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("anime", "Loading ")
                    }

                    is Resource.Error -> {
                        Log.e("anime", it.message.toString())


                    }
                    is Resource.Success -> {
                        it.data?.results?.let { it1 -> characterAdapter.setList(it1) }
                    }

                }
            }

        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                id
            )
        )

    }

}