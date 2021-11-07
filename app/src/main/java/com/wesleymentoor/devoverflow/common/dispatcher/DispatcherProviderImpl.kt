package com.wesleymentoor.devoverflow.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherProviderImpl @Inject constructor(): DispatcherProvider {
    override fun ioDispatcher(): CoroutineDispatcher = Dispatchers.IO
    override fun defaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
    override fun mainDispatcher(): CoroutineDispatcher = Dispatchers.Main

}