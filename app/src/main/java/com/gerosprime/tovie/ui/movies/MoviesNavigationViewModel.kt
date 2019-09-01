package com.gerosprime.tovie.ui.movies

import android.app.Application
import com.gerosprime.tovie.components.mvvm.AndroidBaseViewModel
import com.gerosprime.tovie.model.Movie
import com.gerosprime.tovie.usecase.movies.MovieLoaderUseCase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class MoviesNavigationViewModel(application: Application,
                                private val movieLoaderUseCase: MovieLoaderUseCase)
    : AndroidBaseViewModel(application) {

    private lateinit var popularMoviesCached : List<Movie>

    fun loadPopularMovies(fresh : Boolean) : Observable<List<Movie>>? {
        return if (fresh || popularMoviesCached == null)
            movieLoaderUseCase.loadPopularMovies()
                .flatMapCompletable { t ->
                    Completable.fromAction { popularMoviesCached = t } }
                .toObservable()
        else
            Observable.just(popularMoviesCached)
    }

    fun loadTopMovies(fresh : Boolean) : Observable<List<Movie>>? {
        return null
    }

}