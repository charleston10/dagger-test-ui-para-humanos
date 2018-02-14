package com.example.charleston.daggerespresso

import android.support.test.rule.ActivityTestRule
import com.example.charleston.daggerespresso.features.MainActivity
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

    val server = MockWebServer()

    @Before
    fun setup() {
        server.setDispatcher(MockServerDispatcher())
        server.start(36004)
        server.url("/")
    }

    @Test
    fun testOnCreate() {
        activityRule.launchActivity(null)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}