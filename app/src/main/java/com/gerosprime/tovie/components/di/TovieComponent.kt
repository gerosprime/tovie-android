package com.gerosprime.tovie.components.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [ScreenProvider::class, UseCaseProvider::class,
    AndroidInjectionModule::class])
@Singleton
interface TovieComponent {

}