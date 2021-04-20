package com.example.droidskmmsample

import platform.darwin.dispatch_queue_t

import kotlinx.coroutines.*
import platform.darwin.dispatch_async
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Main

internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}