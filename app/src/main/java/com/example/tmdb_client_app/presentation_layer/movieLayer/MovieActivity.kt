package com.example.tmdb_client_app.presentation_layer.movieLayer

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
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory:MovieViewModelFactory

    private lateinit var binding:ActivityMovieBinding
    private lateinit var movieViewModel:MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie)
        /*(application as Injector).createMovieSubComponent()
            .inject(this)*/

        movieViewModel=ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)
        initRecyclerView()



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter=MovieAdapter()
        binding.movieRecyclerView.adapter=adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.movieprogressBar.visibility= View.VISIBLE
        val responseLiveData=movieViewModel.getMovies()

        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieprogressBar.visibility=View.GONE
            }
            else{
                binding.movieprogressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Data",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.movieprogressBar.visibility=View.VISIBLE
        val response=movieViewModel.updateMovie()
        response.observe(this, Observer{
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieprogressBar.visibility=View.GONE
            }else{
                binding.movieprogressBar.visibility=View.GONE
            }
        })
    }
}
