package com.example.charleston.daggerespresso.di

import android.app.Application
import com.example.charleston.daggerespresso.App
import com.example.charleston.daggerespresso.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by charleston on 09/02/18.
 */
@Singleton
@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                MainActivityModule::class,
                AndroidInjectorActivityBindingModule::class,
                AppModule::class,
                ServiceModule::class,
                RequestModule::class,
                NetworkModule::class)
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }
}