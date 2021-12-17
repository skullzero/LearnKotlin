package com.onion.learn.kotlin.coroutine.builders

import kotlinx.coroutines.*
import kotlin.random.Random

/*
    async是CoroutineScope的扩展函数，因此只有在CoroutineScope可用时才能使用。
    在需要返回值的情况下，使用async构建器。
*/
suspend fun main() = performAsync()


@OptIn(ExperimentalCoroutinesApi::class)
suspend fun performAsync() {
    /*
        coroutineScope是一个挂起函数，它会等待所有包含的协程执行完毕后才退出, 不必轮询才能知道所有协程是否
        执行完毕，这是它的优点之一
        与runBlocking不同的是，它的优点是不阻塞主线程，但是必须作为suspend函数的一部分来调用
    */
    coroutineScope {
        /*
            async将返回值包装在Deferred实例中
            所以firstSum和secondSum都是Deferred<Int>类型；接口Deferred继承自Job接口
            Deferred value is a non-blocking cancellable future — it is a Job with a result.
        */
        val firstSum = async {
            println(Thread.currentThread().name)
            addInts(2, 2)
        }
        val secondSum = async {
            println(Thread.currentThread().name)
            addInts(3, 4)
        }
        println("Awaiting concurrent sums...")
        println(firstSum.isCompleted)
        //调用await阻塞，直到这两个协程执行完毕。await是Deferred的一个方法
        val total = firstSum.await() + secondSum.await()
        println("Total is $total")

        //判断当前任务是否完成
        println(firstSum.isCompleted)
        /*
            获得执行结果
            如果Coroutine还没有执行完成则会抛出 IllegalStateException ，如果任务被取消了也会抛出对应的异常。
        */
        println(firstSum.getCompleted())
    }
}

suspend fun addInts(x: Int, y: Int): Int {
    delay(Random.nextLong(1000L))
    return x + y
}