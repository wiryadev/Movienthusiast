package com.wiryadev.movienthusiast.core.domain

import com.wiryadev.movienthusiast.core.data.MovieRepository
import com.wiryadev.movienthusiast.core.domain.mapper.toDomain
import com.wiryadev.movienthusiast.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNowPlayingMovieUseCase(
    private val repository: MovieRepository,
) {
    operator fun invoke(): Flow<List<Movie>> {
        return repository.getNowPlayingMovies()
            .map { it.toDomain() }
    }
}