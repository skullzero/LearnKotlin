package com.onion.learn.kotlin.classes

/*
    1. kotlin中创建一个单例类的方式极其简单，只需要将class关键字改成object关键字，而不需要私有化构造函数，
       也不需要提供getInstance()这样的静态方法。
    2.
*/
object SingletonTest {
    fun singleTonTest() {
        println("singletonTest is called")
    }
}

fun main() {
    /*
        调用单例类中的函数也简单，比较类似于java中的静态方法调用方式。
        kotlin在背后帮我们自动创建类一个SingletonTest类的实例，并保证全局只会有一个SingletonTest实例。
    */
    SingletonTest.singleTonTest()
}