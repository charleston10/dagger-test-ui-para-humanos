package com.example.charleston.daggerespresso

import android.app.Activity
import android.app.Application
import android.app.Service
import android.support.annotation.VisibleForTesting
import com.example.charleston.daggerespresso.di.AppComponent
import com.example.charleston.daggerespresso.di.DaggerAppComponent
import com.example.charleston.daggerespresso.di.modules.AppModule
import com.example.charleston.daggerespresso.di.modules.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

/**
 * Created by charleston on 09/02/18.
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @set:VisibleForTesting
    lateinit var component: AppComponent

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        component = createComponent()
        component.inject(this)
    }

    fun createComponent(): AppComponent {
        return DaggerAppComponent
                .builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}