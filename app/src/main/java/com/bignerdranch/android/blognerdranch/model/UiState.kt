package com.bignerdranch.android.blognerdranch.model



data class UiState(
    var posts: List<Post>? =null,
    var post: Post?=null,
    var postMetadata: List<PostMetadata>? = null
)
