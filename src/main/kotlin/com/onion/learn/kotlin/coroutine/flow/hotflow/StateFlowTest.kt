package com.onion.learn.kotlin.coroutine.flow.hotflow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.text.SimpleDateFormat
import java.util.*

/*
    热流其实是观察者模式（或者广播）的概念，发布端无论有没有订阅者，都会始终执行，并且有多个订阅者时，发布端跟订阅者是一对多的关系，
    热流可以与多个订阅者共享信息。
 */
@OptIn(DelicateCoroutinesApi::class)
suspend fun testStateIn() {
    val scope = CoroutineScope(Dispatchers.Unconfined)
    val simpleDateFormat = SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault())

    //只执行一遍
    val sharedFlow = flow {
        for (i in 0..5) {
            val timeString = simpleDateFormat.format(System.currentTimeMillis())
            println("${this.hashCode()}触发发送数据 index = $i 时间 = $timeString")
            emit("Index = $i Time = $timeString")
        }

    //使用stateIn(记录)函数也可以一对多，但是它只会将最后一个数据分享给订阅者。

    //}.shareIn(scope = scope, started = SharingStarted.WhileSubscribed(), replay = 20)
    //}.shareIn(scope = scope, started = SharingStarted.Lazily, replay = 20)
    }.stateIn(scope = scope)

    /*
       这里创建了两个协程并且延迟错开分别调用了collect，这是为了证明上面的flow发送数据的代码块里只执行了一遍。
     */
    GlobalScope.launch {
        delay(2000)
        sharedFlow.collect {
            println("Result A = $it")
        }
    }


    GlobalScope.launch {
        delay(3000)
        sharedFlow.collect {
            println("Result B = $it")
        }
    }
}

suspend fun main(): Unit = coroutineScope {
    testStateIn()
    //如果不加，等不到协程执行完，main就执行完毕了
    delay(5000)
}
