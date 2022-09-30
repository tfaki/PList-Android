package com.loftymr.plist.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by talhafaki on 29.09.2022.
 */

data class PListResponse<out T>(
    @SerializedName("data")
    val data: T? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("error")
    val error: Error? = null
) {
     data class Error(
         @SerializedName("code")
         val code: Int? = null,
         @SerializedName("message")
         val message: String? = null
     )
}