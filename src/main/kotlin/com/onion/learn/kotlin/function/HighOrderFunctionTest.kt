package com.onion.learn.kotlin.function

/*
    1. 如果一个函数接收另一个函数作为参数，或者返回值的类型是另一个函数，那么该函数就称为高阶函数。
    2. 不同于定义一个普通的字段类型，函数类型的定义语法例子如下:
       (String, Int) -> Unit
       既然是定义一个函数类型，那么最重要的就是要声明函数接收声明参数，以及它的返回值是什么。
       因此，->左边的部分就是用来声明该函数接收什么参数的，多个参数之间用逗号隔开；
       如果不接受任何参数，写一对空括号就可以了。
       而->右边的部分用于声明函数的返回值是什么类型，如果没有返回值就使用Unit，它大致相当于Java中的void
    3. 高阶函数允许让函数类型的参数来决定函数的执行逻辑。即使同一个高阶函数，只要传入不同的函数类型参数，执行
       逻辑和最终的返回结果可能是完全不同的。
*/
fun main() {
    val num1 = 100
    val num2 = 80

    /*
        调用方式1：定义一个与函数类型参数相匹配的函数
        ::plus是一种函数引用方式的写法，表示plus()函数作为参数传递给num1AndNum2()
     */
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)
    println("result1 is $result1")
    println("result2 is $result2")

    /*
        调用方式2：lambda表达式
    */
    //当lambda参数是函数的最后一个参数时，可以将lambda表达式移到函数括号外面
    val result3 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
    val result4 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }
    println("result3 is $result3")
    println("result4 is $result4")

}

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}