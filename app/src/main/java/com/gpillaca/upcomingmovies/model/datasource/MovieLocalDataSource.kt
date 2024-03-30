package com.gpillaca.upcomingmovies.model.datasource

import com.gpillaca.upcomingmovies.model.database.Movie
import com.gpillaca.upcomingmovies.model.database.MovieDao
import kotlinx.coroutines.flow.Flow

class MovieLocalDataSource(
    private val movieDao: MovieDao
) {

    val movies: Flow<List<Movie>> = movieDao.getAll()

    suspend fun save(movies: List<Movie>) {
        movieDao.insertMovies(movies)
    }

    suspend fun isEmpty(): Boolean = movieDao.movieCount() == 0

    fun findMovie(id: Int) = movieDao.findByID(id)

    suspend fun updateMovie(movie: Movie) = movieDao.updateMovie(movie)
}
