package com.example.charleston.daggerespresso.di

import android.app.Application
import com.example.charleston.daggerespresso.App
import com.example.charleston.daggerespresso.di.modules.*
import com.example.charleston.daggerespresso.features.MainActivity
import com.example.charleston.daggerespresso.features.MainPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by charleston on 09/02/18.
 */
@Singleton
@Component(
        modules = arrayOf(
                AndroidInjectionModule::class,
                AppModule::class,
                WorkerModule::class,
                RequestModule::class,
                PresenterModule::class,
                NetworkModule::class
        )
)
interface AppComponent {

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}