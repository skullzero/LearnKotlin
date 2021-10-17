package com.onion.learn.kotlin.classes

/*
    kotlin中匿名类的写法和java有一点区别，由于kotlin完全舍弃来new关键字，因此创建匿名类实例的时候就不能再
    使用new来，而是改用了object关键字
*/
fun main() {
    Thread(object: Runnable {
        override fun run() {
            println("Thread is running")
        }
    }).start()
}