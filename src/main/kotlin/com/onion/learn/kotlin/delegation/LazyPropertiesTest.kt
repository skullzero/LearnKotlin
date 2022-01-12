package com.onion.learn.kotlin.delegation

fun main() {
    lateinit var username: String

    /*
        1. 默认情况下是线程安全的，委托给lazy(initializer: () -> T): Lazy<T> = SynchronizedLazyImpl(initializer)，即初始化操作
        只在首先调用的第一个线程上执行，其他线程使用缓存后的值。
        2. PUBLICATION模式支持同时多个线程调用，并且可以在全部或这部分线程上同时进行初始化。如果某个值已经由另一个线程初始化，则将返回该值，
        而不进行初始化。
        3. NONE模式不是线程安全的。
    */
    //val age: Int by lazy(LazyThreadSafetyMode.SYNCHRONIZED)
    val age: Int by lazy {
        println("10")
        println("20")
        30
    }

    username = "Tom"
    println(username)
    println(age)    //第一次调用，初始化
    println("---------------------")
    println(age)    //第二次调用，直接返回初始化值
}