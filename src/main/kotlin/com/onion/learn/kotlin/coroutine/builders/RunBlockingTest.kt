package com.onion.learn.kotlin.coroutine.builders

import kotlinx.coroutines.*

/*
    runBlocking对于命令行演示或测试很有用。
    顾名思义，它将阻塞当前线程，并等待所有其中包含的协程执行完毕。
*/

fun main() {
    println("Before creating coroutine")
    /*
        runBlocking不是suspend函数，所以可以在普通函数中调用它。
        runBlocking接收两个参数：
            第一个是CoroutineContext,有默认值；
            第二个是以suspend函数作为参数，然后将其作为扩展函数添加到CoroutineScope上，
            执行该函数，然后返回提供的函数返回的任意值。
        launch和async的定义也是类似的参数
    */
    runBlocking {
        println("Hello, ")
        delay(200L)
        println("My context is: $coroutineContext")
        println("My job is: ${coroutineContext[Job]}")
        println("World!")
    }
    println("After coroutine is finished")
}