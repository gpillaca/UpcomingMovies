package com.gpillaca.upcomingmovies.framework.database

import com.gpillaca.upcomingmovies.data.datasource.MovieLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRoomDataSource @Inject constructor(
    private val movieDao: MovieDao
) : MovieLocalDataSource {

    override val movies: Flow<List<MovieDB>> = movieDao.getAll()

    override suspend fun save(movies: List<MovieDB>) {
        movieDao.insertMovies(movies)
    }

    override suspend fun isEmpty(): Boolean = movieDao.movieCount() == 0

    override fun findMovie(id: Int) = movieDao.findByID(id)

    override suspend fun updateMovie(movie: MovieDB) = movieDao.updateMovie(movie)
}