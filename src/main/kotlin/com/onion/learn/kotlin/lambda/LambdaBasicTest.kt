package com.onion.learn.kotlin.lambda

/*
    1. Lambda就是一小段可以作为参数传递的代码。
    2. 一般情况下，向某个函数只能传入变量，而借助lambda却可以传入一小段代码。
    3. 通常不建议在lambda中编写太长的代码，否则可能影响代码的可读性。
    4. lambda的语法结构 {参数名1:参数类型, 参数名2:参数类型, .... -> 函数体}
*/
fun main() {
    val fruitList = listOf("Apple", "Banana", "Pear", "Grape", "Orange")
    val lambda = {fruit: String -> fruit.length}
    val maxLengthFruit = fruitList.maxByOrNull(lambda)
    println(maxLengthFruit)

    //简化1
    val maxLengthFruit2 = fruitList.maxByOrNull({fruit: String -> fruit.length})
    println("简化1：$maxLengthFruit2")

    /*
        简化2
        Kotlin中，当lambda参数是函数的最后一个参数时，可以将lambda表达式移到函数括号外面
    */
    val maxLengthFruit3 = fruitList.maxByOrNull{fruit: String -> fruit.length}
    println("简化2：$maxLengthFruit3")

    /*
        简化3
        依仗类型推导，省略参数类型
    */
    val maxLengthFruit4 = fruitList.maxByOrNull{fruit -> fruit.length}
    println("简化3：$maxLengthFruit4")

    /*
        简化4
        当lambda表达式的参数列表中只有一个参数时，也不必声明参数名，可以用it关键字来代替
    */
    val maxLengthFruit5 = fruitList.maxByOrNull{ it.length }
    println("简化4：$maxLengthFruit5")


    /*
        当lambda参数是函数的最后一个参数时，可以将lambda表达式移到函数括号外面
    */
    printString("many fruits") {
        println("the length of $it is ${it.length}")
    }
}

fun printString(str: String, printIt: (String) -> Unit) {
    println("printString start")
    printIt(str)
    println("printString end")
}