package com.zxcwldar.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemLocationsBinding
import com.zxcwldar.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder>() {
    private var list: List<RickAndMortyLocation> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: List<RickAndMortyLocation>) {
        this.list = list
        notifyDataSetChanged()
    }

    class LocationsViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyLocation: RickAndMortyLocation) {
            binding.tvName.text = rickAndMortyLocation.name
            binding.tvType.text = rickAndMortyLocation.type
            binding.tvDimension.text = rickAndMortyLocation.dimension

        }


    }
}