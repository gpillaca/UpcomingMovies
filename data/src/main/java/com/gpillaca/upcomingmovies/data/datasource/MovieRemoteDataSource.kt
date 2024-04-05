package com.gpillaca.upcomingmovies.data.datasource

import com.gpillaca.upcomingmovies.domain.common.Either
import com.gpillaca.upcomingmovies.domain.Movie
import com.gpillaca.upcomingmovies.domain.common.Error

interface MovieRemoteDataSource {
    suspend fun findPopularMovies(region: String): Either<Error, List<Movie>>
}
