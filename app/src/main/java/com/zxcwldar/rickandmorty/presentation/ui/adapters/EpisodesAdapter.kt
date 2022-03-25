package com.zxcwldar.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemEpisodesBinding
import com.zxcwldar.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode

class EpisodesAdapter :
    PagingDataAdapter<RickAndMortyEpisode, EpisodesAdapter.EpisodeViewHolder>(EpisodesComparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    inner class EpisodeViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyEpisode: RickAndMortyEpisode) {

            binding.tvName.text = rickAndMortyEpisode.name
            binding.tvAirDate.text = rickAndMortyEpisode.air_date
            binding.tvEpisode.text = rickAndMortyEpisode.episode


        }

    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }

}

object EpisodesComparator : DiffUtil.ItemCallback<RickAndMortyEpisode>() {
    override fun areItemsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(
        oldItem: RickAndMortyEpisode,
        newItem: RickAndMortyEpisode
    ): Boolean {
        return oldItem == newItem

    }

}