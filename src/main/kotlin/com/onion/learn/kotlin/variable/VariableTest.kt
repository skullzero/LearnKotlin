package com.onion.learn.kotlin.variable

/*
    Kotlin中定义一个变量，只允许在变量前声明两种关键字: val和var
    1. val(value)用来声明一个不可变的变量，这种变量在初始赋值后就再也不能重新赋值，对应java中的final变量
    2. var(variable)用来声明一个可变的变量，这种变量在初始赋值后仍然可以再被重新赋值，对应java中的非final
    变量
 */
/*
    为什么不直接全部用var来避免val的限制呢? -> 为了解决java中final关键字没有被合理使用的问题

    在java中，除非主动声明变量为final，否则这个变量就是可变的。然而这并不是一件好事，当项目越来越负责，参与
    的人越来越多时，永远无法知道一个可变的变量会在什么时候被谁给修改了，即使它原本不该被修改，这就经常会导致
    一些很难排查的问题。
*/

/*
   什么时候该使用val，什么时候使用var?

   永远优先使用val来声明一个变量，而当val无法满足需求时再使用var，这样设计出来的程序会更加健壮，也更加
   符合高质量的编码规范。
*/
fun main() {
    //Kotlin可以根据赋的值进行类型推导
    val v1 = 10
    //v1 += 10 //error, val cannot be reassigned
    println(v1)

    var v2 = 10
    v2 += 10
    println(v2)

    //当变量需要延迟赋值时，类型推导无法工作，必须显式声明变量类型
    var v3: Int
    v3 = 100
    println(v3)

    /*
        Kotlin抛弃来java中的基本数据类型，全部使用来对象数据类型。在java中int是关键字，而在Kotlin中Int
        变成来一个类，它拥有自己的方法和继承结构。
    */
}

class User {
    companion object {
        /*
            val是kotlin的关键字；而const是一个修饰符, 修饰编译时常量
            const必须和val一起使用，而不是代替val
        */
        const val MIN_AGE = 1
    }
}