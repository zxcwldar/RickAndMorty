package com.zxcwldar.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemLocationsBinding
import com.zxcwldar.rickandmorty.data.remote.dtos.location.RickAndMortyLocation

class LocationsAdapter :
    PagingDataAdapter<RickAndMortyLocation, LocationsAdapter.LocationsViewHolder>
        (LocationComparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder =
        LocationsViewHolder(
            ItemLocationsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
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

object LocationComparator : DiffUtil.ItemCallback<RickAndMortyLocation>() {
    override fun areItemsTheSame(
        oldItem: RickAndMortyLocation,
        newItem: RickAndMortyLocation
    ): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(
        oldItem: RickAndMortyLocation,
        newItem: RickAndMortyLocation
    ): Boolean {
        return oldItem.id == newItem.id
    }


}