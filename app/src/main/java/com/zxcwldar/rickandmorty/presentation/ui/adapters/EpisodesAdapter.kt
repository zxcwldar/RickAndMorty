package com.zxcwldar.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemEpisodesBinding
import com.zxcwldar.rickandmorty.data.remote.dtos.episode.RickAndMortyEpisode

class EpisodesAdapter : RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder>() {
    private var list: List<RickAndMortyEpisode> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder =
        EpisodeViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =
        list.size

    fun setList(list: List<RickAndMortyEpisode>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class EpisodeViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyEpisode: RickAndMortyEpisode) {

            binding.tvName.text = rickAndMortyEpisode.name
            binding.tvAirDate.text = rickAndMortyEpisode.air_date
            binding.tvEpisode.text = rickAndMortyEpisode.episode


        }

    }

}