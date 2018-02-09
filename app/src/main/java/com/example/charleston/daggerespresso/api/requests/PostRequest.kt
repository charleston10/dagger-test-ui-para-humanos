package com.example.charleston.daggerespresso.api.requests

import com.example.charleston.daggerespresso.data.PostData
import retrofit2.Call
import retrofit2.http.GET


interface PostRequest {

    @GET("/posts")
    fun getPosts(): Call<List<PostData>>
}