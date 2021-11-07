package com.wesleymentoor.devoverflow.common.util

import retrofit2.HttpException
import java.io.IOException

fun errorMessage(throwable: Throwable): String {
    return when (throwable) {
        is HttpException -> {
            throwable.localizedMessage ?: "Something went wrong"
        }
        is IOException -> {
            "Could not connect to the internet. Please check your internet connection and try again."
        }
        else -> {
                "An unknown error occurred!"
        }
    }

}