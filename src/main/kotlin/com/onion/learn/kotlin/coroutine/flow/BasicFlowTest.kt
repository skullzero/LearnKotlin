package com.onion.learn.kotlin.coroutine.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Kotlin协程中使用挂起函数（Suspend函数）可以异步地返回单个计算结果，
    但是如果有多个计算结果希望通过协程的方式异步返回，这时可以使用Flow

    flow{ ... } 构建一个Flow类型
    flow{ ... }内可以使用suspend函数.
    emit方法用来发射数据
    collect方法用来遍历结果

    Flow的另外两种创建方式
    1. flowOf 创建一个保护固定数量的flow，类似listOf
    2. 任意集合类或者sequence通过.asFlow()转成一个flow
       例如可以将一个IntRange转成一个flow
       (1..3).asFlow().collect { value -> println(value) }
*/

    //使用 List<Int> 意味着我们的结果只能一次性返回
    suspend fun fooWithoutFlow() : List<Int> {
        delay(1000) // pretend we are doing something asynchronous here
        return listOf(1, 2, 3)
    }

    /*
        使用Flow<Int>
        1. 可以像Sequence<Int>一样逐条计算后返回流式结果
        2. 计算可以在异步完成，不会阻塞UI
        3. Flow是冷流, 即在调用collect之前，flow{ ... }中的代码不会执行
    */
    fun foo(): Flow<Int> = flow { // foo()不需要是suspend函数
        for (i in 1..3) {
            delay(100) // pretend we are doing something useful here
            emit(i) // emit next value
        }
    }

    fun main() = runBlocking {
        //1s后结果被一次性输出
        fooWithoutFlow().forEach { value -> println("without flow $value") }

        println("-------------------------------------")

        // Launch a concurrent coroutine to check if the main thread is blocked
        launch {
            for (k in 1..3) {
                println("I'm not blocked $k")
                delay(100)
            }
        }

        /*
            Hot streams push values even when there is no one consuming them.
            However, cold streams, start pushing values only when you start collecting.
            Kotlin Flow is an implementation of cold streams.
        */
        foo().collect { value -> println("with flow $value") }
    }
