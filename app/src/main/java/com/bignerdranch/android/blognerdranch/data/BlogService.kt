package com.bignerdranch.android.blognerdranch.data

import com.bignerdranch.android.blognerdranch.model.Post
import com.bignerdranch.android.blognerdranch.model.PostMetadata
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogService {

    @GET("post-metadata")
    suspend fun getPostMetadata(): List<PostMetadata>

    @GET("post/{id}")
    suspend fun getPost(@Path("id") id: Int): Post

    @GET("post")
    suspend fun getPost(): List<Post>
}