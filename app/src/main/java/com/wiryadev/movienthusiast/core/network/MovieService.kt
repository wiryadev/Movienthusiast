package com.wiryadev.movienthusiast.core.network

import com.wiryadev.movienthusiast.core.network.response.BaseResponse
import com.wiryadev.movienthusiast.core.network.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = "31634d4ff259e10457127397d6c94f57"
    ): BaseResponse<List<MovieResponse>>

}