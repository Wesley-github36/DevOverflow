package com.wesleymentoor.devoverflow.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun ioDispatcher(): CoroutineDispatcher
    fun defaultDispatcher(): CoroutineDispatcher
    fun mainDispatcher(): CoroutineDispatcher
}