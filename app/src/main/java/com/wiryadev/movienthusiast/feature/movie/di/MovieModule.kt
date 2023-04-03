package com.wiryadev.movienthusiast.feature.movie.di

import com.wiryadev.movienthusiast.di.domainModule
import com.wiryadev.movienthusiast.feature.movie.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val movieModule = module {
    includes(domainModule)
    viewModelOf(::MovieViewModel)
}