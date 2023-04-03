package com.wiryadev.movienthusiast.di

import com.wiryadev.movienthusiast.core.domain.GetNowPlayingMovieUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)

    factoryOf(::GetNowPlayingMovieUseCase)
}