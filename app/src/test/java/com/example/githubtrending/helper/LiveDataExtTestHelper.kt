package com.example.githubtrending.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@Throws(InterruptedException::class)
fun <T> LiveData<T>.getTestValue(): T? {
    var value: T? = null
    val latch = CountDownLatch(1)
    val observer = Observer<T> {
        value = it
        latch.countDown()
    }
    latch.await(2, TimeUnit.SECONDS)
    observeForever(observer)
    removeObserver(observer)
    return value
}