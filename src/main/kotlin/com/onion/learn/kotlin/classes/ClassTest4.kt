package com.onion.learn.kotlin.classes

/*
    此例为特殊情况，只有次构造函数，没有主构造函数
*/
fun main() {
    val stu4 = Student4("Jack", 10)
    stu4.eat()
}

open class Person4(val name: String, private val age: Int) {
    fun eat() {
        println("$name is eating. He is $age years old.")
    }
}

/*
    Student4类的后面没有显式地定义主构造函数，同时又因为定义类次构造函数。既然没有主构造函数，继承
    Person类的时候就不需要加上括号了。
*/
class Student4: Person4 {
    /*
        由于没有主构造函数，次构造函数只能直接调用父类的构造函数，所以将this换成了super关键字
    */
    constructor(name: String, age: Int): super(name, age) {
    }
}