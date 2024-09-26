package com.example.tmdb_client_app.presentation_layer.artistLayer

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.databinding.ActivityArtistBinding
import com.example.tmdb_client_app.presentation_layer.movieLayer.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArtistBinding
    private lateinit var artistViewModel: ArtistViewModel
    @Inject
    lateinit var factory:ArtistViewModelFactory
    private lateinit var adapter: ArtistAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_artist)
        /*(application as Injector).createArtistSubComponent()
            .inject(this)*/

        artistViewModel=ViewModelProvider(this,factory).get(ArtistViewModel::class.java)
        initRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initRecyclerView() {
        binding.artistrecyclerView.layoutManager=LinearLayoutManager(this)
        adapter= ArtistAdapter()
        binding.artistrecyclerView.adapter=adapter
        displayArtist()
    }

    private fun displayArtist() {
        binding.artistprogressBar.visibility= View.VISIBLE
        val responseLiveData = artistViewModel.getArtist()
        Log.i("MyTag","X")
        responseLiveData.observe(this, Observer {
            if (it != null) {
                Log.i("MyTag", "Data received: ${it.size}")  // Add this log to see the data
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistprogressBar.visibility = View.GONE
            } else {
                Log.i("MyTag", "Data is null")
                binding.artistprogressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Error Loading", Toast.LENGTH_LONG).show()
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator:MenuInflater=menuInflater
        inflator.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateArtist()
                true
            }
            else->super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtist() {
        binding.artistprogressBar.visibility=View.VISIBLE
        val responseLiveData=artistViewModel.updateArtist()

        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistprogressBar.visibility=View.GONE
            }
            else{
                binding.artistprogressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"Error Loading",Toast.LENGTH_LONG).show()
            }
        })
    }


}