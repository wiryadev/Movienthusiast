package com.wiryadev.movienthusiast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.wiryadev.movienthusiast.feature.movie.MoviesScreen
import com.wiryadev.movienthusiast.ui.theme.MovienthusiastTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovienthusiastTheme {
                MoviesScreen()
            }
        }
    }
}
