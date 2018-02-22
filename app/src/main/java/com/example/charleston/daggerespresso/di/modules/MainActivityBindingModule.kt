package com.example.charleston.daggerespresso.di.modules

import android.app.Activity
import com.example.charleston.daggerespresso.di.MainActivityComponent
import com.example.charleston.daggerespresso.features.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by charleston on 22/02/18.
 */
@Module(subcomponents = arrayOf(MainActivityComponent::class))
abstract class MainActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun mainActivityInjectorFactory(builder: MainActivityComponent.Builder)
            : AndroidInjector.Factory<out Activity>
}
