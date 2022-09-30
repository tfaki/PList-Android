package com.loftymr.plist.data.remote.repository

import com.loftymr.plist.data.remote.service.PListService
import com.loftymr.plist.domain.request.SignupRequest
import javax.inject.Inject

/**
 * Created by talhafaki on 29.09.2022.
 */
class PListRepository @Inject constructor(
    private val pListService: PListService
): PListBaseRepository() {

    suspend fun signUp(signupRequest: SignupRequest) = safeApiCall {
        pListService.signUp(
            signupRequest
        )
    }
}