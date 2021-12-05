package com.onion.learn.kotlin.coroutine.builders

import kotlinx.coroutines.*

/*
    如果需要启动协程以执行单独的任务，但又不需要从中取得返回值，可以使用launch。

    launch是CoroutineScope的扩展函数，因此只有在CoroutineScope可用时才能使用。
    它返回Job类型的实例，必要时可用于取消协程。
*/
fun main() {
    println("Before runBlocking")
    runBlocking {
        println("Before launch")
        println("My context is: $coroutineContext")
        println("My job is: ${coroutineContext[Job]}")
        /*
            {}中的suspend函数必须是不带任何参数且不返回任何结果的suspend函数。
        */
        launch {
            println("Hello, ")
            println("My context is: $coroutineContext")
            println("My job is: ${coroutineContext[Job]}")
            delay(200L)
            println("World!")
        }
        println("After launch")
    }

    println("After runBlocking")
}