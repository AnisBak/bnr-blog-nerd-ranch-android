package com.bignerdranch.android.blognerdranch.repository

import android.util.Log
import com.bignerdranch.android.blognerdranch.data.BlogService
import com.bignerdranch.android.blognerdranch.controller.list.PostListActivity
import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(private val blogService: BlogService) {

    suspend fun fetchMetaData(): List<PostMetadata> {
        return try {
            val postMetadata = blogService.getPostMetadata()
            Log.i(PostListActivity.TAG, "Loaded postMetadata $postMetadata")
            postMetadata
        } catch (e: Exception) {
            Log.e(PostListActivity.TAG, "Failed to load postMetadata", e)
            emptyList()
        }
    }


    suspend fun fetchPost(): List<Post>? {
        var post: List<Post>? = null
        return try {
            post = blogService.getPost()
            Log.i(PostListActivity.TAG, "Loaded post $post")
            post
        } catch (e: Exception) {
            Log.e(PostListActivity.TAG, "Failed to load post", e)
            post
        }
    }
}


