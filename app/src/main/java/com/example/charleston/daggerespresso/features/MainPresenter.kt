package com.example.charleston.daggerespresso.features

import com.example.charleston.daggerespresso.api.workers.PostWorker
import com.example.charleston.daggerespresso.data.PostData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by charleston on 09/02/18.
 */
class MainPresenter(val worker: PostWorker) {

    interface MainView {
        fun showPosts(posts: List<PostData>?)
        fun showError(message: String?)
    }

    fun callPosts() {
        worker.getPosts().enqueue(object : Callback<List<PostData>> {
            override fun onResponse(call: Call<List<PostData>>?, response: Response<List<PostData>>?) {
                response?.let {
                    Timber.i("onResponse: %s", response.body())
                }
            }

            override fun onFailure(call: Call<List<PostData>>?, t: Throwable?) {
                Timber.i("onFailure: %s", t?.message)
            }
        })
    }
}