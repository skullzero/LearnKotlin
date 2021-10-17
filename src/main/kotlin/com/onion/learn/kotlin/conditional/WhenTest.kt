package com.onion.learn.kotlin.conditional

/*
    java中的switch的缺点
    1. 只能传入字符串(JDK1.7+)、整型或者短于整型的变量作为条件
    2. 每个case条件都要在最后主动加上一个break, 否则执行完当前case之后会依次执行下面的case，这一特性会因为忘记
       添加break而导致一些奇怪的bug
 */
fun main() {
    println(getScore("Jack"))
    println(getScore2("Jack"))
    checkNumber(10)
    println(getScore3("Tommy"))
}

fun getScore(name: String) = if(name == "Tom") {
    86
} else if (name == "Jim") {
    77
} else if (name =="Jack") {
    95
} else if (name == "Lily") {
    100
} else {
    0
}

/*
    1. 如果判断条件比较多，就是该考虑使用when语句的时候
    2. when语句和if语句一样，也是可以有返回值的
    3. when语句允许传入一个任意类型的参数，然后可以在when的结构体中定义一系列的条件，格式是 匹配值 -> {执行逻辑}
       当执行逻辑只有一行代码，{}可以省略
*/
fun getScore2(name: String) = when(name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}

/*
    除了精确匹配外，when语句还允许进行类型匹配
    is关键字就是类型匹配的核心，它相当于java中的instanceof关键字
*/
fun checkNumber(num: Number) {
    when(num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

/*
    when的无参数用法，某些情况下可以发挥很强的扩展性
*/
fun getScore3(name: String) = when {
    name.startsWith("Tom") -> 86
    name == "Jim" -> 77
    name == "Jack" -> 95
    name == "Lily" -> 100
    else -> 0
}

