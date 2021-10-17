package com.onion.learn.kotlin.classes

interface Study {
    fun readBooks()
    fun doHomework() {
        //默认实现。实现接口的类不再强制要求实现该函数
        println("doHomework default implementation")
    }
}

open class Person5(val name: String, private val age: Int) {
    fun eat() {
        println("$name is eating. He is $age years old.")
    }
}

/*
    java中继承用extends，实现接口使用implements，而kotlin统一使用冒号:
    另外接口的后面不用加上括号，因为它没有构造函数可以调用
*/
class Student5(name: String, age: Int): Person5(name, age), Study {
    override fun readBooks() {
        println("$name is reading")
    }
}

fun main() {
    val student = Student5("Jack", 10)
    student.readBooks()
    student.doHomework()
}