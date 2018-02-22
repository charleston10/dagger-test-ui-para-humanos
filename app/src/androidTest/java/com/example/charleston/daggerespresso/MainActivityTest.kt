package com.example.charleston.daggerespresso

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import com.example.charleston.daggerespresso.extensions.getJson
import com.example.charleston.daggerespresso.features.MainActivity
import com.example.charleston.daggerespresso.viewActions.RecyclerViewItemCountAssertion
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers.greaterThan
import org.hamcrest.Matchers.lessThan
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Created by charleston on 09/02/18.
 */
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val server = MockWebServer()

    @Before
    fun setup() {
        server.start(36004)
        server.url("/")

        activityRule.launchActivity(null)
    }

    @Test
    fun shouldListCountOne() {
        server.enqueue(
                MockResponse()
                        .setResponseCode(200)
                        .setBody(context getJson R.raw.test_posts)
        )

        onView(withId(R.id.main_rv_posts))
                .check(RecyclerViewItemCountAssertion(1))
    }

    @Test
    fun shouldListCountGreaterThanFive() {
        server.enqueue(
                MockResponse()
                        .setResponseCode(200)
                        .setBody(context getJson R.raw.test_posts_10)
        )

        onView(withId(R.id.main_rv_posts))
                .check(RecyclerViewItemCountAssertion(greaterThan(5)))
    }

    @Test
    fun shouldListCountLessThanTen() {
        server.enqueue(
                MockResponse()
                        .setResponseCode(200)
                        .setBody(context getJson R.raw.test_posts_5)
        )

        onView(withId(R.id.main_rv_posts))
                .check(RecyclerViewItemCountAssertion(lessThan(10)))
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}