package com.example.tmdb_client_app.presentation_layer

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.tmdb_client_app.R
import com.example.tmdb_client_app.databinding.ActivityHomeBinding
import com.example.tmdb_client_app.presentation_layer.artistLayer.ArtistActivity
import com.example.tmdb_client_app.presentation_layer.movieLayer.MovieActivity
import com.example.tmdb_client_app.presentation_layer.tvLayer.TvActivity


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.movieButton.setOnClickListener{
          val intent= Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener{
            val intent= Intent(this, TvActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener{
            val intent= Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }


    }
}