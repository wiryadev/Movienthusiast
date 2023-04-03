package com.wiryadev.movienthusiast.core.data

import com.wiryadev.movienthusiast.core.network.response.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getNowPlayingMovies(): Flow<List<MovieResponse>>

}