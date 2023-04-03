package com.wiryadev.movienthusiast

import android.app.Application
import com.wiryadev.movienthusiast.feature.movie.di.movieModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovienthusiastApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MovienthusiastApp)
            modules(movieModule)
        }
    }
}