package com.bignerdranch.android.blognerdranch.controller.list

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.Post

class PostAdapter(var post: List<Post>?) : RecyclerView.Adapter<PostViewHolder>() {

    override fun getItemCount(): Int {
        return post?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = post?.get(position)
        if (post != null) {
            holder.bind(post)
        }
    }

}