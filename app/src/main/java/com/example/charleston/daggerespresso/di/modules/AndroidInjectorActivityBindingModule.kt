package com.example.charleston.daggerespresso.di.modules

import com.example.charleston.daggerespresso.features.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by charleston on 22/02/18.
 */
@Module
abstract class AndroidInjectorActivityBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun bindAndroidInjectorActivity(): MainActivity
}