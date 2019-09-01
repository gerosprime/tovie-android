package com.gerosprime.tovie.ui.movies

import android.app.Application
import com.gerosprime.tovie.model.Movie
import com.gerosprime.tovie.usecase.movies.MovieLoaderUseCase
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesNavigationViewModelTest {

    private val popularMovies = listOf(
        Movie(1, "John Wick", "Action movie"),
        Movie(2, "Avengers", "Fantasy Movie"),
        Movie(3, "Annabol", "Horror Movie"))

    private val popularMoviesCached = listOf(
        Movie(1, "John Wick", "Action movie"),
        Movie(2, "Avengers", "Fantasy Movie"),
        Movie(3, "Annabol", "Horror Movie"))


    @Mock
    lateinit var mockLoaderUseCase: MovieLoaderUseCase

    lateinit var model : MoviesNavigationViewModel

    @Mock
    lateinit var mockApplication: Application

    lateinit var testObserver: TestObserver<List<Movie>>
    @Before
    fun setup() {
        testObserver = TestObserver.create()
        model = MoviesNavigationViewModel(mockApplication, mockLoaderUseCase)
    }

    @Test
    fun loadPopularMovies_freshAndSuccess_returnsListOfMovies() {

        successfulPopularMovies()
        model.loadPopularMovies(true)?.subscribe(testObserver)
        testObserver.assertValue(popularMovies)

    }

    @Test
    fun loadPopularMovies_notFreshAndSuccess_returnsCachedListOfMovies() {
        // TODO Test the cache
    }

    private fun successfulPopularMovies() {
        Mockito.`when`(mockLoaderUseCase.loadPopularMovies())
            .thenReturn(Single.just(popularMovies))
    }

}