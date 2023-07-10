package com.bignerdranch.android.blognerdranch.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class Post (
    var id: Int? = null,
    var metadata: PostMetadata? = null,
    var body: String? = null
) : Parcelable