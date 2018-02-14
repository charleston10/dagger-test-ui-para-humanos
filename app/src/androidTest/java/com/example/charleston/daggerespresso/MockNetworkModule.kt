package com.example.charleston.daggerespresso

import com.example.charleston.daggerespresso.di.modules.NetworkModule

/**
 * Created by charleston on 14/02/18.
 */
class MockNetworkModule: NetworkModule() {
    override fun provideUrlDomain(): String {
        return "/"
    }
}