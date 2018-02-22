package com.example.charleston.daggerespresso.mocks

import com.example.charleston.daggerespresso.di.modules.NetworkModule

/**
 * Created by charleston on 14/02/18.
 */
open class MockNetworkModule: NetworkModule() {
    override fun provideUrlDomain(): String {
        return "http://localhost:36004/"
    }
}