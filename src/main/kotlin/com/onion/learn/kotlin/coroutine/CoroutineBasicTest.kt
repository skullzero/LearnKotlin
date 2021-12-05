package com.onion.learn.kotlin.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
    A coroutine is a concurrency design pattern that you can use on Android to simplify code
    that executes asynchronously.
    协程是一种并发设计模式，可以在Android开发中用来简化异步代码的执行。
    协程可以让我们在单线程下模拟多线程编程的效果，代码执行时的挂起与恢复完全由编程语言来控制，和操作系统无关。

    要创建协程，需要使用以下构建器(builder)之一: runBlocking, launch, async
*/
fun main() {
    /*
        GlobalScope.launch创建了一个顶层协程，其上也定义两相应版本的launch和async。
        但建议一般不使用这种它们。这些函数但问题在于它们会启动未绑定任何特定job的协程，如果不提前取消，它们
        将跨越整个应用程序的生命周期。
    */
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