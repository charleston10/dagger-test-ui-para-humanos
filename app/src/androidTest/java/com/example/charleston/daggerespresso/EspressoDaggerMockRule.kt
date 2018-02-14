package com.example.charleston.daggerespresso

import android.support.test.InstrumentationRegistry
import com.example.charleston.daggerespresso.di.AppComponent
import com.example.charleston.daggerespresso.di.modules.AppModule
import it.cosenonjaviste.daggermock.DaggerMock

/**
 * Created by charleston on 09/02/18.
 */

val app: App get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App

fun espressoDaggerMockRule() = DaggerMock.rule<AppComponent>(
        AppModule(app),
        MockNetworkModule()
) {
    set { component -> app.component = component; }
    customizeBuilder<AppComponent.Builder> { it.application(app) }
}