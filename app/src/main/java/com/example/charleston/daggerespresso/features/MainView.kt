package com.example.charleston.daggerespresso.features

import com.example.charleston.daggerespresso.data.PostData

/**
 * Created by charleston on 22/02/18.
 */
interface MainView {
    fun showPosts(posts: List<PostData>?)
    fun showError(message: String?)
}