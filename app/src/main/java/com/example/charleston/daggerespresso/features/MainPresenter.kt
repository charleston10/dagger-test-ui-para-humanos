package com.example.charleston.daggerespresso.features

import com.example.charleston.daggerespresso.api.services.PostService
import com.example.charleston.daggerespresso.data.PostData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by charleston on 09/02/18.
 */
class MainPresenter @Inject constructor(val view: MainView, val service: PostService) {

    fun callPosts() {
        service.getPosts().enqueue(object : Callback<List<PostData>> {
            override fun onResponse(call: Call<List<PostData>>?, response: Response<List<PostData>>?) {
                response?.let {
                    view.showPosts(response.body())
                    Timber.i("onResponse: %s", response.body())
                }
            }

            override fun onFailure(call: Call<List<PostData>>?, t: Throwable?) {
                view.showError(t?.message)
                Timber.i("onFailure: %s", t?.message)
            }
        })
    }
}