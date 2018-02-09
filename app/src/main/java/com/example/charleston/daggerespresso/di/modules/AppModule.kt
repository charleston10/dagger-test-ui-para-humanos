package com.example.charleston.daggerespresso.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by charleston on 09/02/18.
 */
@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    internal fun providerApplicationContext(): Context {
        return application.applicationContext
    }
}