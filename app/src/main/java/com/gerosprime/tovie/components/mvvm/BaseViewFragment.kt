package com.gerosprime.tovie.components.mvvm

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

open class BaseViewFragment<VM : AndroidBaseViewModel> : Fragment(), AndroidBaseView<VM> {

    @Inject
    protected lateinit var viewModel : VM

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}