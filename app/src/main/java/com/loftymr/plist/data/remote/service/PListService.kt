package com.loftymr.plist.data.remote.service

import com.loftymr.plist.data.model.PListResponse
import com.loftymr.plist.domain.request.SignupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by talhafaki on 29.09.2022.
 */

interface PListService {

    @POST("user")
    suspend fun signUp(
        @Body request: SignupRequest
    ): Response<PListResponse<Boolean>>
}