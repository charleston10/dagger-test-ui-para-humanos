package com.example.charleston.daggerespresso.di

import com.example.charleston.daggerespresso.di.modules.MainActivityModule
import com.example.charleston.daggerespresso.features.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by charleston on 22/02/18.
 */
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}