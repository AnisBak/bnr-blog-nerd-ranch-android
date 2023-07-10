package com.bignerdranch.android.blognerdranch.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class PostMetadata (
    var postId: Int? = null,
    var title: String? = null,
    var summary: String? = null,
    var author: Author? = null,
    var publishDate: String? = null
) : Parcelable