package com.example.charleston.daggerespresso.features

import com.example.charleston.daggerespresso.api.workers.PostWorker
import com.example.charleston.daggerespresso.data.PostData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by charleston on 09/02/18.
 */
class MainPresenter(val view: MainView) {

    @Inject
    lateinit var worker: PostWorker

    interface MainView {
        fun showPosts(posts: List<PostData>?)
        fun showError(message: String?)
    }

    fun callPosts() {
        worker.getPosts().enqueue(object : Callback<List<PostData>> {
            override fun onResponse(call: Call<List<PostData>>?, response: Response<List<PostData>>?) {
                response?.let {
                    view.showPosts(it.body())
                }
            }

            override fun onFailure(call: Call<List<PostData>>?, t: Throwable?) {
                view.showError(t?.message)
            }
        })
    }
}