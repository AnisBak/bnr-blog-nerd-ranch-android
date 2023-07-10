package com.bignerdranch.android.blognerdranch.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Author (
    var name: String? = null,
    var image: String? = null,
    var title: String? = null
    ) : Parcelable