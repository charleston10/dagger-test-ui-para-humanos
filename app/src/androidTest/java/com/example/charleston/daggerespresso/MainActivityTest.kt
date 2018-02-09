package com.example.charleston.daggerespresso

import android.support.test.rule.ActivityTestRule
import com.example.charleston.daggerespresso.di.modules.NetworkModule
import com.example.charleston.daggerespresso.features.MainActivity
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import okhttp3.mockwebserver.MockResponse
import org.bouncycastle.crypto.tls.ConnectionEnd.server



/**
 * Created by charleston on 09/02/18.
 */
class MainActivityTest {

    @get:Rule
    val rule = espressoDaggerMockRule()

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    val networkModule: NetworkModule = mock()

    val server = MockWebServer()

    @Before
    fun start() {
        server.start()
    }

    @Test
    fun testOnCreate() {
        server.enqueue(MockResponse().setBody("hello, world!"))

        whenever(networkModule.provideUrlDomain()).thenReturn("/")

        activityRule.launchActivity(null)
    }

    @After
    fun finish() {
        server.shutdown()
    }
}