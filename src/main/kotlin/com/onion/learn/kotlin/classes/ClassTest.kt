package com.onion.learn.kotlin.classes

fun main() {
    /*
        kotlin中实例化一个类的方式和java是基本类似的，只是去掉来new关键字而已。
        这么设计的原因是因为当调用某个类的构造函数时，只可能是为来对这个类进行实例化，因此即使没有new关键字也可以
        清晰地表达出意图。
     */
    val p = Person()
    p.name = "Jack"
    p.age = 10
    p.eat()
}

/*
    1. Kotlin中任何一个非抽象类默认都是不可以被继承的，相当于java中声明了final关键字
    2. <<Effective Java>>中明确提到，如果一个类不是专门为继承而设计的，那么就应该主动将它加上final声明，
       禁止它可以被继承。
    3. 这和设计val关键字的原因差不多，如果一个允许被继承的化，它无法预知子类会如何实现，因此可能就会存在一些未知
       的风险
    4. 之所以这里强调非抽象类，是因为抽象类本身无法创建实例，一定要由子类去继承它才能创建实例，因此抽象类必须可以
       继承才行
    5. open关键字可以使一个类可以被继承
*/
open class Person {
    var name = ""
    var age = 0

    fun eat() {
        println("$name is eating. He is $age years old.")
    }
}


/*
    1. 冒号:相当于java中extends来实现继承的声明
    2. kotlin将构造函数分成来主构造函数和次构造函数两种
    3. 主构造函数的特定是没有函数体，直接定义在类名后即可。
    4. 实例化时，必须传入主构造函数的所有参数
*/
class Student(private val sno: String, private val grade: Int): Person() {
    //所有主构造函数中的逻辑都可以写在init结构体中
    init {
        println("sno is $sno")
        println("grade is $grade")
    }
}