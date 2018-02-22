package com.example.charleston.daggerespresso

import com.example.charleston.daggerespresso.di.AppComponent
import com.example.charleston.daggerespresso.di.DaggerAppComponent
import com.example.charleston.daggerespresso.di.modules.AppModule
import com.example.charleston.daggerespresso.mocks.MockNetworkModule

/**
 * Created by charleston on 22/02/18.
 */
class TestApp : App() {

    override fun createComponent(): AppComponent {
        return DaggerAppComponent
                .builder()
                .application(this)
                .appModule(AppModule(this))
                .networkModule(MockNetworkModule())
                .build()
    }
}