package com.example.tmdb_client_app.data.repository.movie_repo

import com.example.tmdb_client_app.data.db.MovieDAO
import com.example.tmdb_client_app.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//like a gatekeeper to the local DB
class MovieLocalDataSourceImplementation(private val movieDAO: MovieDAO): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getAllMovies()   //no need coroutine as getting data from DB is implicitly executed from background thread by local Database
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {  //just call this..the corotune io will run savemovies...now if u parallely call say the clearall function then any other coroutine will run it..so paralel
        CoroutineScope(Dispatchers.IO).launch{
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteMovies()
        }
    }
}