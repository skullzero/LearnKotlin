package com.onion.learn.kotlin.classes

fun main() {
    val stu = Student2("1", 2, "Jack", 10)
    stu.printStudentInfo()
    stu.eat()
}

open class Person2(val name: String, private val age: Int) {
    fun eat() {
        println("$name is eating. He is $age years old.")
    }
}


/*
    1. 继承的父类(Person())后加括号的原因如下
       根据继承特性的规定，子类的构造函数必须调用父类的构造函数，而主构造函数没有函数题，init结构体也非必须
       所以kotlin的设计是通过括号来指定调用哪个父类的构造函数，即使是无参的构造函数，括号也不能省略

    2. 下面的Student2声明会报错，因为空括号表明会去调用Person2类的无参构造函数
*/
//class Student2(val sno: String, val grade: Int): Person2() {}


/*
    1. 要解决上面声明的错误，就必须给Person2类的构造函数传入name和age字段
    2. 可以在Student2类的主构造函数中加上name和age这两个参数，再将他们传给Person2类的构造函数
    3. 注意，在Student2类的主构造函数中增加name和age这两个字段时，不能再将它们声明成val，因为在主构造函数
       中声明成val或者var的参数将自动成为该类的字段，这会导致和父类中的同名的name和age字段造成冲突。
       因此，这里的name和age参数前不加任何关键字，让他们的作用域仅限定在主构造函数中即可。
*/
class Student2(private val sno: String, private val grade: Int, name: String, age: Int): Person2(name, age) {
    fun printStudentInfo() {
        println("sno is $sno")
        println("grade is $grade")
    }
}