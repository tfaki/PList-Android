package com.loftymr.plist.data.remote.exception

import java.io.IOException

/**
 * Created by talhafaki on 29.09.2022.
 */
class NoInternetException(
    override val message: String? = "No Internet Connection!"
) : IOException(message)