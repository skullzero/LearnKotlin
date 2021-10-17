package com.onion.learn.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    A coroutine is a concurrency design pattern that you can use on Android to simplify code
    that executes asynchronously.
    协程是一种并发设计模式，可以在Android开发中用来简化异步代码的执行。

    协程可以让我们在单线程下模拟多线程编程的效果，代码执行时的挂起与恢复完全由编程语言来控制，和操作系统无关。

*/
fun main() {
    //GlobalScope.launch创建了一个顶层协程，这种协程当应用程序结束时也会跟着一起结束
    GlobalScope.launch { // launch a new coroutine in background and continue
        /*
            delay是一个非阻塞的挂起函数，只会挂起当前的协程，而不会影响当前线程下其他协程的运行。
        */
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

    println("Hello,") // main thread continues while coroutine is delayed
    /*
        Thread.sleep()方法会祖册当前的线程，这样运行在该线程下的所有协程都会被阻塞
    */
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}