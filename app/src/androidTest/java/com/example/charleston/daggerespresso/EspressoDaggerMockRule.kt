package com.example.charleston.daggerespresso

import android.support.test.InstrumentationRegistry
import com.example.charleston.daggerespresso.di.modules.AppModule
import it.cosenonjaviste.daggermock.DaggerMock

/**
 * Created by charleston on 09/02/18.
 */
fun espressoDaggerMockRule() = DaggerMock.rule<TestAppComponent> {
    set { component -> component.inject(app) }
    customizeBuilder<TestAppComponent.Builder> { it.application(app) }
    customizeBuilder<TestAppComponent.Builder> { it.appModule(AppModule(app)) }
    customizeBuilder<TestAppComponent.Builder> { it.networkModule(MockNetworkModule()) }
}

val app: App get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App