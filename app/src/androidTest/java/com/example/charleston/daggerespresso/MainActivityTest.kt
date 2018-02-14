package com.example.charleston.daggerespresso

import android.support.test.rule.ActivityTestRule
import com.example.charleston.daggerespresso.di.modules.NetworkModule
import com.example.charleston.daggerespresso.features.MainActivity
import com.nhaarman.mockito_kotlin.whenever
import it.cosenonjaviste.daggermock.InjectFromComponent
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Created by charleston on 09/02/18.
 */
class MainActivityTest {

    @get:Rule
    val daggerRule = espressoDaggerMockRule()

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    @InjectFromComponent
    lateinit var networkService: NetworkModule

    val server = MockWebServer()

    @Before
    fun start() {
        server.start()
    }

    @Test
    fun testOnCreate() {
        activityRule.launchActivity(null)

        Thread.sleep(1000)

        server.enqueue(MockResponse().setBody("hello, world!"))
        whenever(networkService.provideUrlDomain()).thenReturn("/")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}