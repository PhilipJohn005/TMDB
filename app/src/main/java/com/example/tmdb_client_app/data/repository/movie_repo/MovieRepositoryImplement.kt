package com.example.tmdb_client_app.data.repository.movie_repo

import android.util.Log
import com.example.tmdb_client_app.data.model.movie.Movie
import com.example.tmdb_client_app.domain.movie_use_case.MovieRepository

//this class depends on data sources
class MovieRepositoryImplement(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getAllMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies=getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            val response=movieRemoteDataSource.getMovies()
            val body=response.body()
            if(body!=null)
                movieList=body.movies
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList=movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.size>0)
            return movieList
        else{
            movieList=getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList=movieCacheDataSource.getMoviesFromCache()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.size>0)
            return movieList
        else{
            movieList=getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}