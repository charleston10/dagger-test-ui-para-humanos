package com.example.charleston.daggerespresso.features

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.charleston.daggerespresso.R
import com.example.charleston.daggerespresso.data.PostData
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.callPosts()
    }

    override fun showPosts(posts: List<PostData>?) {
        Timber.i("showPosts: %s", posts)
    }

    override fun showError(message: String?) {
        Timber.i("showError: %s", message)
    }
}