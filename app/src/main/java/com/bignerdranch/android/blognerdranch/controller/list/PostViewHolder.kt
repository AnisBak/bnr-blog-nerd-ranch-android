package com.bignerdranch.android.blognerdranch.controller.list

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bignerdranch.android.blognerdranch.R
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import com.bignerdranch.android.blognerdranch.controller.post.PostActivity
import com.bignerdranch.android.blognerdranch.model.Post

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var post: Post? = null

    val titleTextView: TextView = itemView.findViewById(R.id.title_textview)
    val authorTextView: TextView = itemView.findViewById(R.id.author_textView)
    val summaryTextView: TextView = itemView.findViewById(R.id.summary_textView)
    val publishDateTextView: TextView = itemView.findViewById(R.id.publish_date_textView)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(post: Post) {
        this.post = post
        post.metadata?.apply {
            titleTextView.text = this.title
            authorTextView.text= this.author?.name
            summaryTextView.text = this.summary
            publishDateTextView.text = this.publishDate
        }
    }

    override fun onClick(v: View) {
        val context = v.context
        context.startActivity(post?.let { PostActivity.newIntent(v.context, it) })
    }

}