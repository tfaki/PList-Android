package com.loftymr.plist.data.remote.exception

/**
 * Created by talhafaki on 29.09.2022.
 */
class PListException(
    val httpCode: Int? = null,
    override val message: String? = null,
    val messageCode: String? = null
) : Exception(message)