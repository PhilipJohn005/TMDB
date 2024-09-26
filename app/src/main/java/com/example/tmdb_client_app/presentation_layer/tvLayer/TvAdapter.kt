package com.example.tmdb_client_app.presentation_layer.tvLayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.data.model.tvshow.TV
import com.example.tmdb_client_app.databinding.ListItemBinding

class TvAdapter():RecyclerView.Adapter<MyViewHolder>() {
    private var tvList=ArrayList<TV>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding:ListItemBinding=DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvList[position])
    }

    fun setList(tvs:List<TV>){
        tvList.clear()
        tvList.addAll(tvs)
    }
}

class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(tv: TV){
        binding.titleTextView.text=tv.name
        binding.descriptionTextView.text=tv.overview
        val posterURL="https://image.tmdb.org/t/p/w500"+tv.posterPath
        Glide.with(binding.imageView.context).load(posterURL)
            .into(binding.imageView)
    }
}