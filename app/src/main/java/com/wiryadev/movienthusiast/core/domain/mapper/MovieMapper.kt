package com.wiryadev.movienthusiast.core.domain.mapper

import com.wiryadev.movienthusiast.core.domain.model.Movie
import com.wiryadev.movienthusiast.core.network.response.MovieResponse

fun MovieResponse.toDomain() = Movie(
    id = id ?: 0,
    title = title.orEmpty(),
    posterUrl = "https://image.tmdb.org/t/p/original$posterPath",
    synopsis = overview.orEmpty(),
)

fun List<MovieResponse>.toDomain() = this.map { it.toDomain() }