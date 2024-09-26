package com.example.tmdb_client_app.presentation_layer.tvLayer

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
import com.example.tmdb_client_app.databinding.ActivityTvBinding
import com.example.tmdb_client_app.presentation_layer.movieLayer.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class TvActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTvBinding
    private lateinit var tvViewModel: TvViewModel
    @Inject
    lateinit var factory: TvViewModelFactory
    private lateinit var adapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_tv)
        /*(application as Injector).createTvSubComponent()
            .inject(this)*/
        try {
            tvViewModel = ViewModelProvider(this, factory).get(TvViewModel::class.java)

        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }

        initRecyclerView()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initRecyclerView() {
        binding.tvrecyclerView.layoutManager=LinearLayoutManager(this)
        adapter=TvAdapter()
        binding.tvrecyclerView.adapter=adapter

        displayPopularTv()
    }

    private fun displayPopularTv() {
        binding.tvprogressBar.visibility= View.VISIBLE
        val responseLiveData=tvViewModel.getTv()

        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvprogressBar.visibility=View.GONE
            }else{
                binding.tvprogressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"Server Error",Toast.LENGTH_LONG).show()
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
                updateTv()
                true
            }

            else ->super.onOptionsItemSelected(item)
        }

    }

    private fun updateTv(){
        binding.tvprogressBar.visibility=View.VISIBLE
        val response=tvViewModel.updateTv()
        response.observe(this, Observer {
            if(it!=null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvprogressBar.visibility = View.GONE
            }else{
                binding.tvprogressBar.visibility=View.GONE
                Toast.makeText(applicationContext,"Server Error",Toast.LENGTH_LONG).show()
            }
        })
    }

}