package com.loftymr.plist.domain.request

/**
 * Created by talhafaki on 29.09.2022.
 */
data class SignupRequest(
    var name: String? = null,
    var lastname: String? = null,
    var email: String? = null,
    var number: String? = null,
    var password: String? = null
)