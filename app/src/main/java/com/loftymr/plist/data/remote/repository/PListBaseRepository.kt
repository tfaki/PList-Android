package com.loftymr.plist.data.remote.repository

import android.content.Context
import com.loftymr.plist.data.model.PListResponse
import com.loftymr.plist.data.remote.exception.NoInternetException
import com.loftymr.plist.data.remote.exception.PListException
import com.loftymr.plist.domain.extension.fromJson
import com.loftymr.plist.domain.extension.tryCatch
import com.loftymr.plist.domain.util.PListUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
import java.net.HttpURLConnection
import javax.inject.Inject

/**
 * Created by talhafaki on 29.09.2022.
 */

abstract class PListBaseRepository {

    @Inject
    @ApplicationContext
    lateinit var context: Context

    protected suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<PListResponse<T>>,
    ): Result<T?> {
        return runCatching {
            val response = call.invoke()
            val responseBody = response.body()

            if (!PListUtils.networkUtils.isNetworkAvailable(context)) {
                throw NoInternetException()
            }

            when (response.code()) {
                HttpURLConnection.HTTP_NOT_FOUND -> throw Exception()
                HttpURLConnection.HTTP_INTERNAL_ERROR -> throw Exception()
                else -> {
                    val message = tryCatch {
                        val errorBodyStr = response.errorBody()?.string()
                        val errorResponse = errorBodyStr?.fromJson<PListResponse<T>>() ?: responseBody
                        errorResponse?.error?.message
                    }
                    throw PListException(response.code(), message)
                }
            }
        }
    }
}