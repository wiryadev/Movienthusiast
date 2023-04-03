package com.wiryadev.movienthusiast.core.data

import com.wiryadev.movienthusiast.core.network.MovieRemoteDataSource
import com.wiryadev.movienthusiast.core.network.response.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemoteDataSource,
) : MovieRepository {

    override fun getNowPlayingMovies(): Flow<List<MovieResponse>>  = flow {
        emit(remoteDataSource.getNowPlayingMovies())
    }
}