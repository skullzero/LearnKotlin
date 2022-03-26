package com.onion.learn.kotlin.generic

fun main() {
    printThing("a")
    printThing(1)
    printThing(1.0)

    printThings("Tom", 20)
    printThings(20, 20.0)

    printEquals(1, 2)
    printEquals(1.0, 1.0)
    //printEquals(5, "abc") 错误

    //任何没有类型约束的类型参数，也有限定类型，即Any?, 即也可以接收空值
    printThing(null)

    printNonNullThing("hello")
    //printNonNullThing(null) 错误
}

/*
    1. 在函数名isEquals前加<T>就表示其为泛型函数
    2. <T>是声明类型参数，T是类型参数
    3. 函数中参数类型被声明为T，在调用函数时，T会被实际的类型替代
    4. 类型参数，可以是任何大写或者小写的英文字母组成；一般情况下使用T,E和U等大写字母
*/
private fun <T> printThing(thing: T) {
    println(thing)
}

/*
    1. 可同时声明多个类型参数，它们之间用逗号分隔
    2. 类型参数不仅可以用来声明函数的参数类型，还可以声明函数的返回类型
*/
private fun <T, V> printThings(thing: T, anotherThing: V) {
    println("$thing and $anotherThing")
}

/*
    使用T:Number将类型限定为数字类型，这种表示方式称为 类型约束
*/
private fun <T: Number> printEquals(p1: T, p2: T) {
    if(p1 == p2) {
        println("$p1 equals $p2")
    } else {
        println("$p1 not equal $p2")
    }
}

/*
    如果不想接收任何可空类型，可用Any作为类型约束
*/
private fun <T: Any> printNonNullThing(thing: T) {
    println(thing)
}