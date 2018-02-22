package com.example.charleston.daggerespresso.di.modules

import com.example.charleston.daggerespresso.features.MainActivity
import com.example.charleston.daggerespresso.features.MainView
import dagger.Binds
import dagger.Module

/**
 * Created by charleston on 22/02/18.
 */

@Module
abstract class MainActivityModule {

    @Binds
    internal abstract fun provideMainView(mainActivity: MainActivity): MainView
}