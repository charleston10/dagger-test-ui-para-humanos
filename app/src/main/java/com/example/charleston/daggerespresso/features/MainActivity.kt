package com.example.charleston.daggerespresso.features

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.charleston.daggerespresso.App
import com.example.charleston.daggerespresso.R
import com.example.charleston.daggerespresso.data.PostData
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.inject(this)

        presenter.callPosts()
    }

    override fun showPosts(posts: List<PostData>?) {
        Timber.i("showPosts: %s", posts)
    }

    override fun showError(message: String?) {
        Timber.i("showError: %s", message)
    }
}