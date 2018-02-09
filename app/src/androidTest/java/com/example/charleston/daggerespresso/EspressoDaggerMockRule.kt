package com.example.charleston.daggerespresso

import android.support.test.InstrumentationRegistry
import com.example.charleston.daggerespresso.di.AppComponent
import com.example.charleston.daggerespresso.di.modules.AppModule
import com.nhaarman.mockito_kotlin.mock
import it.cosenonjaviste.daggermock.DaggerMock

/**
 * Created by charleston on 09/02/18.
 */
fun espressoDaggerMockRule() = DaggerMock.rule<AppComponent>(AppModule(app)) {
    set { component -> component.inject(app) }
    customizeBuilder<AppComponent.Builder> { it.application(app) }
    customizeBuilder<AppComponent.Builder> { it.appModule(mock()) }
}

val app: App get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App