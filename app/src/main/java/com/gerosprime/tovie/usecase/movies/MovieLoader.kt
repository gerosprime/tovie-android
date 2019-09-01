package com.gerosprime.tovie.usecase.movies

import com.gerosprime.tovie.model.Movie
import io.reactivex.rxjava3.core.Single

interface MovieLoaderUseCase {
    fun loadPopularMovies() : Single<List<Movie>>
}