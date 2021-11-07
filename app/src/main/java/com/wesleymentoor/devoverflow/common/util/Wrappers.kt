package com.wesleymentoor.devoverflow.common.util

import java.lang.Exception

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val error: String?
){
    companion object {

        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data, null)
        fun <T> error(msg: String): Resource<T> = Resource(Status.ERROR, null, msg)
        fun <T> loading(data: T?): Resource<T> = Resource(Status.LOADING, data, null)
    }

}
enum class Status { LOADING, SUCCESS, ERROR }


