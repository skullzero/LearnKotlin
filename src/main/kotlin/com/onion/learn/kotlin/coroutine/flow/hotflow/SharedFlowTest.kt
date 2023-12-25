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
suspend fun testShareIn() {
    val scope = CoroutineScope(Dispatchers.Unconfined)
    val simpleDateFormat = SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault())

    //只执行一遍
    val sharedFlow = flow {
        for (i in 0..5) {
            val timeString = simpleDateFormat.format(System.currentTimeMillis())
            println("${this.hashCode()}触发发送数据 index = $i 时间 = $timeString")
            emit("Index = $i Time = $timeString")
        }
        /*
         shareIn的参数：
            scope 是创建热流的协程域
            started 为热流的启动模式;
                Eagerly 没订阅/观察就发送数据; shareIn被调用后，共享数据(立即执行flow发送数据的代码块)是立即开始，永远不会停止。
                Lazily 第一个collect(订阅者)被调用后，共享数据(flow发送数据的代码块)才会开始，永远不会停止。
                WhileSubscribed() 第一个collect(订阅者)被调用后，共享数据(flow发送数据的代码块)才会开始，在最后一个订阅者消失时立即停止(默认情况下)，并永久保留重播缓存(默认情况下)。
            replay为缓存数据的数量，不能设置为0，否则在没有订阅者时会立刻丢弃缓存的数据
                如果reply设置的小于实际的数据数量，则取最新的N条
         */
    //}.shareIn(scope = scope, started = SharingStarted.WhileSubscribed(), replay = 20)
    //}.shareIn(scope = scope, started = SharingStarted.Lazily, replay = 20)
    }.shareIn(scope = scope, started = SharingStarted.Eagerly, replay = 4)

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

@OptIn(DelicateCoroutinesApi::class)
suspend fun testSharedFlowWithoutReplay() {
    val mutableSharedFlow = MutableSharedFlow<String>()
    mutableSharedFlow.emit("1 - first")
    mutableSharedFlow.emit("2 - second")

    GlobalScope.launch {
        mutableSharedFlow.collect {
            println("testSharedFlowWithoutReplay $it")
        }
    }

    //此处延迟两秒来保证协程中的消费者已经生产者建立起联系，否则数据都会被丢弃
    delay(2000)
    mutableSharedFlow.emit("3 - third")
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun testSharedFlowWithReplay() {
    val mutableSharedFlow = MutableSharedFlow<String>(3)
    mutableSharedFlow.emit("1 - first")
    mutableSharedFlow.emit("2 - second")

    GlobalScope.launch {
        mutableSharedFlow.collect {
            println("testSharedFlowWithReplay $it")
        }
    }

    //由于设置了replay，此处不再需要delay
    mutableSharedFlow.emit("3 - third")
}

suspend fun main(): Unit = coroutineScope {
    testShareIn()
    testSharedFlowWithoutReplay()
    testSharedFlowWithReplay()
    //如果不加，等不到协程执行完，main就执行完毕了
    delay(5000)
}
