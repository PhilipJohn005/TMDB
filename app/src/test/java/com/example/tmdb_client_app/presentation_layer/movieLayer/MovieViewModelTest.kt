package com.example.tmdb_client_app.presentation_layer.movieLayer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.data.movie_repo.movie.FakeMovieRepository
import com.example.tmdb_client_app.domain.movie_use_case.GetMoviesUseCase
import com.example.tmdb_client_app.domain.movie_use_case.UpdateMovieUseCase
import com.example.tmdb_client_app.domain.tv_use_case.UpdateTvUseCase
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    //instantTaskexecuter rule runs all jetpack architecture componenets background jobs in the same thread....bcs of tht result is syncronously
    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()   //we shld use this instanttaskExecutor rule when doing with livedata

    private lateinit var movieViewModel:MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository=FakeMovieRepository()
        val getmoviesUseCase=GetMoviesUseCase(fakeMovieRepository)
        val updatemoviesUseCase=UpdateMovieUseCase(fakeMovieRepository)
        movieViewModel=MovieViewModel(getmoviesUseCase,updatemoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList(){
        val movies= mutableListOf<Movie>()
        movies.add(Movie(1,"overview1","path1","date1","title1"))
        movies.add(Movie(2,"overview2","path2","date2","title2"))

       // val gotMovies=movieViewModel.getMovies().getOrAwai....
    }
}