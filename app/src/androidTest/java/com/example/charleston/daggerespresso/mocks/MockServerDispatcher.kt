package com.example.charleston.daggerespresso.mocks

import android.content.Context
import com.example.charleston.daggerespresso.App
import com.example.charleston.daggerespresso.R
import com.example.charleston.daggerespresso.extensions.getJson
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

/**
 * Created by charleston on 14/02/18.
 */
class MockServerDispatcher(private val context: Context) : Dispatcher() {

    override fun dispatch(request: RecordedRequest?): MockResponse {
        return when (request?.path) {
            "/posts" -> {
                MockResponse()
                        .setResponseCode(200)
                        .setBody(context getJson R.raw.test_posts)
            }
            else -> MockResponse().setResponseCode(404)
        }
    }
}