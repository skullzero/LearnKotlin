package com.onion.learn.kotlin.function

import java.lang.Math.max

/*
    fun是定义函数的关键字，无论定义声明函数，都一定要用fun来声明
    参数声明格式"参数名:参数类型"
 */
fun main() {
    val num = largerNumber(10, 20)
    println(num)

    println(largerNumber2(20, 30))
}

/*
    参数括号后的部分是可选的，用于声明该函数会返回什么类型的数据
 */
fun largerNumber(num1: Int, num2: Int): Int {
    return max(num1, num2)
}

/*
    当一个函数只有一行代码时，Kotlin允许不必编写函数体，可以直接将唯一的一行代码写在定义的尾部，中间用
    等号连接即可。
    使用这种语法，return关键字也可以省略
 */
fun largerNumber2(num1: Int, num2: Int): Int = max(num1, num2)