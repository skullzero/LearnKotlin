package com.onion.learn.kotlin.coroutine.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.*

/*
     Flow默认是冷流的，冷流的概念是只有订阅者订阅后，发布者才会生产数据。
     并且订阅者与发布者是一一对应关系，数据只会给目标订阅者发送，不会发送给其他订阅者。这类似于你去工厂下订单，工厂才会生产你需要的产品，
     并且只发送给你。
*/
suspend fun testColdFlow() {
    //每次collect都重新执行一次
    val coldFlow = flow<String> {
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val timeString = simpleDateFormat.format(System.currentTimeMillis())
        println("coldFlow ${this.hashCode()} 触发发送数据 时间 = $timeString")
        emit(timeString)
    }

    //每次collect都重新执行一次
    val coldFlow2 = flow<String> {
        for(i in 0..5) {
            val simpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val timeString = simpleDateFormat.format(System.currentTimeMillis())
            println("coldFlow2 ${this.hashCode()} 触发发送数据 index = $i 时间 = $timeString")
            emit(timeString)
        }
    }

    /*
        下面用了一个for循环，分别间隔一秒collect一次，而从结果可以看到每次的时间都是不一样的，
        这说明每一次collect，flow的代码块都重新执行了一遍：
    */
    for (index in 0..2) {
        delay(1000)
        coldFlow.collect {
            //collect调用它了，flow才会执行
            println("结果 = $it ")
        }
    }

    // 此处再次证明每次collect都是新的flow对象
    coldFlow2.collect {
        println("Result A = $it")
    }
    delay(2000)
    coldFlow2.collect {
        println("Result B = $it")
    }
}

suspend fun main() {
    coroutineScope {
        testColdFlow()
    }
}

