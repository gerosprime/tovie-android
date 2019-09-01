package com.gerosprime.tovie.components.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class AndroidBaseViewModel
    constructor(application: Application) : AndroidViewModel(application), BaseViewModel