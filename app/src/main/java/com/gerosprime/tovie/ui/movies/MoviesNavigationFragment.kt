package com.gerosprime.tovie.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gerosprime.tovie.components.mvvm.BaseViewFragment

class MoviesNavigationFragment : BaseViewFragment<MoviesNavigationViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var inflated : View = inflater.inflate()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}