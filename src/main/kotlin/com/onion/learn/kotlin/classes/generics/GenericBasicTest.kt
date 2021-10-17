package com.onion.learn.kotlin.classes.generics

/*
    什么是泛型？在一般的编程模式下，我们需要给任何一个变量指定一个具体的类型，而泛型允许我们在不指定
    具体类型的情况下进行编程，这样编写出来的代码会有更好的扩展性。

    泛型主要有两种定义方式：一种是定义泛型类；另一种是定义泛型方法，使用的语法结构都是使用<T>。当然括号内的T并不是
    固定的，可以使用任何英文字母或单词都可以。
*/
fun main() {
    val box = Box(1)
    box.printBox()

    val box2 = Box("hello box")
    box2.printBox()

    val param = Builder().returnValue("Hello Builder")
    println(param)
}

/*
    泛型类的定义方法是在类名后加上<T>
*/
class Box<T>(private val t: T) {
    fun printBox() {
        println(t)
    }
}

class Builder {
    /*
        泛型方法的定义是在方法名前加上<T>
    */
    fun <T> returnValue(param: T): T {
        return param
    }
}