package com.wiryadev.movienthusiast.feature.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.wiryadev.movienthusiast.core.domain.model.Movie
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieViewModel = koinViewModel(),
) {
    val uiState by viewModel.nowPlayingMovie.collectAsState()

    when (uiState) {
        is MovieViewModel.MovieUiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    (uiState as MovieViewModel.MovieUiState.Error).message,
                    style = MaterialTheme.typography.displayLarge.copy(
                        color = MaterialTheme.colorScheme.error
                    )
                )
            }
        }

        is MovieViewModel.MovieUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        is MovieViewModel.MovieUiState.Success -> {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = modifier,
            ) {
                movies(movies = (uiState as MovieViewModel.MovieUiState.Success).movies)
            }
        }
    }
}

fun LazyGridScope.movies(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
) {
    items(movies, key = { it.id }) { movie ->
        Box(modifier = modifier) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            )
            Text(
                text = movie.title,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(8.dp)
                    .align(Alignment.BottomCenter),
            )
        }
    }
}