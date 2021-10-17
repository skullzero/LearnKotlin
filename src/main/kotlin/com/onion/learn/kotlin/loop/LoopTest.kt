package com.onion.learn.kotlin.loop

/*
    Kotlin的while循环在语法和使用技巧上都和java中的while循环没有区别
    java中常用的for-i循环在kotlin中被直接舍弃了，而java中的for-each被kotlin增强为for-in循环
*/
fun main() {

    //其中..是创建两端闭区间的关键字，在..的两边指定区间的左右端点就可以创建一个区间了
    for(i in 0..10) {
        println(i)
    }

    println("------------------------------")

    //可以使用until关键字来创建一个左闭右开的区间
    //step设置递增量
    for(i in 0 until 10 step 2) {
        println(i)
    }

    println("------------------------------")

    //使用downTo创建两端闭合的降序空间
    for(i in 10 downTo 0) {
        println(i)
    }
}