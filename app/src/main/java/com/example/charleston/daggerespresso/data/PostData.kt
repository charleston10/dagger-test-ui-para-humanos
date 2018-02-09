package com.example.charleston.daggerespresso.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by charleston on 09/02/18.
 */
data class PostData(
        @SerializedName("userId") val userId: Long,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
) : Serializable