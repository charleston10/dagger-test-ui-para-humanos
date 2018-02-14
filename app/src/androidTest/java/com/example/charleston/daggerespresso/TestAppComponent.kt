package com.example.charleston.daggerespresso

import android.app.Application
import com.example.charleston.daggerespresso.di.modules.AppModule
import com.example.charleston.daggerespresso.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by charleston on 14/02/18.
 */
@Singleton
@Component(
        modules = arrayOf(
                AndroidInjectionModule::class,
                NetworkModule::class,
                AppModule::class
        )
)
interface TestAppComponent {

    fun inject(app: App)
    fun inject(mainActivityTest: MainActivityTest)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun appModule(appModule: AppModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): TestAppComponent
    }
}