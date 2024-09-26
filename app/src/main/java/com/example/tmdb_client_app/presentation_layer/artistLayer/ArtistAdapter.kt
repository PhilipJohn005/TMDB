package com.example.tmdb_client_app.presentation_layer.artistLayer

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.data.model.artist.Artist
import com.example.tmdb_client_app.data.model.tvshow.TV
import com.example.tmdb_client_app.databinding.ListItemBinding

class ArtistAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private var artistList=ArrayList<Artist>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    fun setList(persons:List<Artist>){
        artistList.clear()
        artistList.addAll(persons)
    }
}

class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(person: Artist){
        binding.titleTextView.text=person.name
        binding.descriptionTextView.text=person.popularity.toString()
        val posterURL="https://image.tmdb.org/t/p/w500"+person.profilePath
        Glide.with(binding.imageView.context).load(posterURL)
            .into(binding.imageView)
    }
}