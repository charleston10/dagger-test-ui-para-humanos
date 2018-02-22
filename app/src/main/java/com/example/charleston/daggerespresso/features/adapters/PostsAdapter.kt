package com.example.charleston.daggerespresso.features.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.charleston.daggerespresso.R
import com.example.charleston.daggerespresso.data.PostData

/**
 * Created by charleston on 22/02/18.
 */
class PostsAdapter(val posts: List<PostData>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostsAdapter.PostViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsAdapter.PostViewHolder?, position: Int) {
        holder?.run {
            txtTitle?.text = posts[position].title
            txtMessage?.text = posts[position].body
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class PostViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val txtTitle by lazy { itemView?.findViewById<TextView>(R.id.item_post_txt_title) }
        val txtMessage by lazy { itemView?.findViewById<TextView>(R.id.item_post_txt_message) }
    }
}