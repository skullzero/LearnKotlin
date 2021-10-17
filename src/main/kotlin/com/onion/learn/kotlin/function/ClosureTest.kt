package com.onion.learn.kotlin.function


/*
    closures are functions that can access and modify properties defined
    outside the scope of function.

    关于kotlin中闭包的理解：由于lambada和匿名函数就是所谓的定义在函数中的函数，他们需要具有能访问父函数中
    的局部变量的能力。
*/
fun main() {
    f1()
}

fun f1() {
    var sum = 0
    val ints = listOf(1,2,3,0,5)

    ints.filter { it > 0 }.forEach {
        sum += it
    }
    println(sum)


    val sum2 = fun(): Int {
        return sum + 1
    }
    println(sum2())
}



