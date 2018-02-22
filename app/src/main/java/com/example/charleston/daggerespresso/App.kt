package com.example.charleston.daggerespresso

import android.app.Activity
import android.app.Application
import android.app.Service
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.charleston.daggerespresso.di.AppComponent
import com.example.charleston.daggerespresso.di.DaggerAppComponent
import com.example.charleston.daggerespresso.di.modules.AppModule
import com.example.charleston.daggerespresso.di.modules.NetworkModule
import dagger.android.*
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by charleston on 09/02/18.
 */
open class App : Application(), HasActivityInjector, Application.ActivityLifecycleCallbacks {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @set:VisibleForTesting
    lateinit var component: AppComponent

    private val fragmentLifecycleCallbacks: FragmentManager.FragmentLifecycleCallbacks
        get() =
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, b: Bundle?) {
                    AndroidSupportInjection.inject(f)
                }
            }

    init {
        registerActivityLifecycleCallbacks(this)
    }

    override fun onCreate() {
        super.onCreate()

        setupDagger()
        setupLoggers()
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
    override fun onActivityCreated(activity: Activity?, p1: Bundle?) = handleActivity(activity)
    override fun onActivityPaused(p0: Activity?) {}
    override fun onActivityResumed(p0: Activity?) {}
    override fun onActivityStarted(p0: Activity?) {}
    override fun onActivityDestroyed(p0: Activity?) {}
    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {}
    override fun onActivityStopped(p0: Activity?) {}

    open fun createComponent(): AppComponent {
        return DaggerAppComponent
                .builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    private fun setupDagger() {
        component = createComponent()
        component.inject(this)
    }

    private fun setupLoggers() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun handleActivity(activity: Activity?) {
        if (activity is AppCompatActivity) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity
                    .supportFragmentManager
                    .registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks, true)
        }
    }
}