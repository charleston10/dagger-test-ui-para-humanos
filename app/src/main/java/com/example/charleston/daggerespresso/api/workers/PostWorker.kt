package com.example.charleston.daggerespresso.api.workers

import com.example.charleston.daggerespresso.api.requests.PostRequest
import com.example.charleston.daggerespresso.data.PostData
import retrofit2.Call

/**
 * Created by charleston on 09/02/18.
 */
class PostWorker(val request: PostRequest) {

    fun getPosts(): Call<List<PostData>>{
        return request.getPosts()
    }
}