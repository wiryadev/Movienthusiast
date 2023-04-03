package com.wiryadev.movienthusiast.core.network

import com.wiryadev.movienthusiast.core.network.response.MovieResponse

class MovieRemoteDataSource(
    private val movieService: MovieService
) {
    suspend fun getNowPlayingMovies(): List<MovieResponse> {
        return movieService.getNowPlayingMovies().results ?: emptyList()
    }
}