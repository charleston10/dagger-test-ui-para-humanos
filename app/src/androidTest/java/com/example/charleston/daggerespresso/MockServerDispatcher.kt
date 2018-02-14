package com.example.charleston.daggerespresso

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

/**
 * Created by charleston on 14/02/18.
 */
class MockServerDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest?): MockResponse {
        return when (request?.path) {
            "/posts" -> {
                MockResponse().setResponseCode(200).setBody("[{\n" +
                        "  \"userId\": 1,\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                        "  \"body\": \"quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto\"\n" +
                        "}]")
            }
            else -> MockResponse().setResponseCode(404)
        }
    }
}