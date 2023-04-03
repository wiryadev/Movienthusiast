package com.wiryadev.movienthusiast.feature.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wiryadev.movienthusiast.core.domain.GetNowPlayingMovieUseCase
import com.wiryadev.movienthusiast.core.domain.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MovieViewModel(
    private val getNowPlayingMovie: GetNowPlayingMovieUseCase
) : ViewModel() {

    private val _nowPlayingMovies: MutableStateFlow<MovieUiState> =
        MutableStateFlow(MovieUiState.Loading)
    val nowPlayingMovie: StateFlow<MovieUiState> = _nowPlayingMovies.asStateFlow()

    init {
        getNowPlayingMovies()
    }

    fun getNowPlayingMovies() = viewModelScope.launch {
        getNowPlayingMovie()
            .onStart {
                _nowPlayingMovies.emit(MovieUiState.Loading)
            }
            .catch {
                _nowPlayingMovies.emit(MovieUiState.Error(it.message.orEmpty()))
            }
            .collect {
                _nowPlayingMovies.emit(MovieUiState.Success(it))
            }
    }

    sealed interface MovieUiState {
        data class Success(val movies: List<Movie>) : MovieUiState
        class Error(val message: String) : MovieUiState
        object Loading : MovieUiState
    }
}