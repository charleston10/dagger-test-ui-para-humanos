package com.example.charleston.daggerespresso.features

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.charleston.daggerespresso.R
import com.example.charleston.daggerespresso.data.PostData
import com.example.charleston.daggerespresso.features.adapters.PostsAdapter
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private val list by lazy { findViewById<RecyclerView>(R.id.main_rv_posts) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.callPosts()
    }

    override fun showPosts(posts: List<PostData>?) {
        if (posts != null) {
            list.apply {
                addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = PostsAdapter(posts)
            }
        }
        Timber.i("showPosts: %s", posts)
    }

    override fun showError(message: String?) {
        Timber.i("showError: %s", message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}