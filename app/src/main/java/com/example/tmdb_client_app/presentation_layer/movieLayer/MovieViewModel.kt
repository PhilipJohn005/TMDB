package com.example.tmdb_client_app.presentation_layer.movieLayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb_client_app.domain.movie_use_case.GetMoviesUseCase
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
    ):ViewModel() {

        fun getMovies()= liveData{    /*just like coroutines launched in viewModelScope, the coroutines inside the liveData builder automatically stop when there are no observer UI elements to it (such as when the app is closed). This makes liveData a good choice for lifecycle-aware tasks that only need to run when the UI is active and observing the data.*/
            val movieList=getMoviesUseCase.excute()
            emit(movieList)
        }

        fun updateMovie()= liveData {
            val movieList=updateMovieUseCase.execute()
            emit(movieList)
        }
}