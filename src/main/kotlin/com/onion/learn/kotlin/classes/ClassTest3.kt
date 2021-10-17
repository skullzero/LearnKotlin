package com.onion.learn.kotlin.classes

/*
    任何一个类只能有一个主构造函数，但可以有多个次构造函数
*/

fun main() {
    val stu3 = Student3("1", 5, "Jack", 10)
    stu3.printStudentInfo()
    stu3.eat()

    println("----------------------------")

    val stu32 = Student3("Jack", 10)
    stu32.printStudentInfo()
    stu32.eat()

    println("----------------------------")

    val stu33 = Student3()
    stu33.printStudentInfo()
    stu33.eat()
}

open class Person3(val name: String, private val age: Int) {
    fun eat() {
        println("$name is eating. He is $age years old.")
    }
}

/*
    1. 当一个类既有主构造函数又有次构造函数，所有但次构造函数都必须调用主构造函数(包括间接调用)
    2. 次构造函数通过constructor关键字定义
*/
class Student3(private val sno: String, private val grade: Int, name: String, age: Int): Person3(name, age) {
    /*
        接收name和age参数，然后通过this关键字调用主构造函数，并将sno和grade赋初始值
    */
    constructor(name: String, age: Int): this("", 0, name, age) {
    }

    /*
        不接收任何参数，通过this关键字调用了第一个次构造函数，并将name和age赋初始值。
        由于第二个次构造函数间接调用了主构造函数，因此也是合法的。
    */
    constructor(): this("", 0) {
    }

    fun printStudentInfo() {
        println("sno is $sno")
        println("grade is $grade")
    }
}