package com.onion.learn.kotlin.conditional

fun main() {
    val num1 = 10
    val num2 = 20

    println(largerNumber(num1, num2))
    println(largerNumber2(num1, num2))
    println(largerNumber3(num1, num2))
    println(largerNumber4(num1, num2))
}

/*
    Kotlin的if用法和java中的if几乎没有区别
 */
fun largerNumber(num1: Int, num2: Int): Int {
    var value = 0
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }

    return value
}

/*
    Kotlin的if相比较java有一个额外的功能，
    它是可以有返回值的，返回值就是if语句每一个条件中最后一行代码的返回值。
    所以largerNumber()可以简化为如下形式
 */
fun largerNumber2(num1: Int, num2: Int): Int {
    val value = if (num1 > num2) {
        num1
    } else {
        num2
    }

    return value
}

/*
    进一步简化
 */
fun largerNumber3(num1: Int, num2: Int): Int {
    return  if (num1 > num2) {
        num1
    } else {
        num2
    }
}

/*
    语法糖：当一个函数只有一行代码时，可以省略函数体部分
 */
fun largerNumber4(num1: Int, num2: Int) = if (num1 > num2) num1 else num2