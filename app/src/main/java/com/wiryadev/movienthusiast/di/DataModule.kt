package com.wiryadev.movienthusiast.di

import com.wiryadev.movienthusiast.core.data.MovieRepository
import com.wiryadev.movienthusiast.core.data.MovieRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    includes(networkModule)

    singleOf(::MovieRepositoryImpl) bind MovieRepository::class
}