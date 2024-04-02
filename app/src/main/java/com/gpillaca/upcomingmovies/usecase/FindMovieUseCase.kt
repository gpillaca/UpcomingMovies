package com.gpillaca.upcomingmovies.usecase

import com.gpillaca.upcomingmovies.data.repository.MovieRepository
import com.gpillaca.upcomingmovies.domain.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Test class [FindMovieUseCaseTest]
 */
class FindMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(id: Int): Flow<Movie> = movieRepository.findMovie(id)
}
