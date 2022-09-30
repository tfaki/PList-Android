package com.loftymr.plist.domain.extension

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import logcat.LogPriority
import logcat.asLog
import logcat.logcat

/**
 * Created by talhafaki on 29.09.2022.
 */

fun <T, R> T.tryCatch(priority: Int? = Log.ERROR, block: (T) -> R): R? {
    return try {
        block(this)
    } catch (t: Throwable) {
        priority?.let { Logcat.log(it, t) }
        null
    }
}

inline fun <reified T> String?.fromJson(gson: Gson = Gson()): T? {
    return tryCatch {
        gson.fromJson<T>(this, object : TypeToken<T>() {}.type)
    }
}


object Logcat {

    fun v(message: String?, tag: String? = null) {
        logcat(
            priority = LogPriority.VERBOSE,
            tag = tag
        ) {
            message.orEmpty()
        }
    }

    fun v(t: Throwable, tag: String? = null) {
        logcat(
            priority = LogPriority.VERBOSE,
            tag = tag
        ) {
            t.asLog()
        }
    }

    fun d(message: String?, tag: String? = null) {
        logcat(
            priority = LogPriority.DEBUG,
            tag = tag
        ) {
            message.orEmpty()
        }
    }

    fun d(t: Throwable, tag: String? = null) {
        logcat(
            priority = LogPriority.DEBUG,
            tag = tag
        ) {
            t.asLog()
        }
    }

    fun i(message: String?, tag: String? = null) {
        logcat(
            priority = LogPriority.INFO,
            tag = tag
        ) {
            message.orEmpty()
        }
    }

    fun i(t: Throwable, tag: String? = null) {
        logcat(
            priority = LogPriority.INFO,
            tag = tag
        ) {
            t.asLog()
        }
    }

    fun w(message: String?, tag: String? = null) {
        logcat(
            priority = LogPriority.WARN,
            tag = tag
        ) {
            message.orEmpty()
        }
    }

    fun w(t: Throwable, tag: String? = null) {
        logcat(
            priority = LogPriority.WARN,
            tag = tag
        ) {
            t.asLog()
        }
    }

    fun e(message: String?, tag: String? = null) {
        logcat(
            priority = LogPriority.ERROR,
            tag = tag
        ) {
            message.orEmpty()
        }
    }

    fun e(t: Throwable, tag: String? = null) {
        logcat(
            priority = LogPriority.ERROR,
            tag = tag
        ) {
            t.asLog()
        }
    }


    fun log(priority: Int, message: String?, tag: String? = null) {
        logcat(
            priority = priority.convertToLogPriority(),
            tag = tag
        ) {
            message.orEmpty()
        }
    }

    fun log(priority: Int, t: Throwable, tag: String? = null) {
        logcat(
            priority = priority.convertToLogPriority(),
            tag = tag
        ) {
            t.asLog()
        }
    }

    private fun Int.convertToLogPriority(): LogPriority {
        return when (this) {
            Log.VERBOSE -> LogPriority.VERBOSE
            Log.DEBUG -> LogPriority.DEBUG
            Log.INFO -> LogPriority.INFO
            Log.WARN -> LogPriority.WARN
            Log.ERROR -> LogPriority.ERROR
            Log.ASSERT -> LogPriority.ASSERT
            else -> LogPriority.VERBOSE
        }
    }

}
