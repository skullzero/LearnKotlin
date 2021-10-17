package com.onion.learn.kotlin.classes.data

/*
    1. 在一个规范的系统架构中，数据类通常占据着非常重要的角色，他们用于将服务器端或数据库中的数据映射到内存中，
    为变成逻辑提供数据模型的支持。
    2. MVC, MVP,MVVM之类的架构模式，不管哪一种，其中的M指就是数据类。
    3. Java中数据类通常需要重写equals(), hashCode(), toString()这几个方法。
    4. 而kotlin中只需在类前面声明了data关键字时，就表明这个类是一个数据类，kotlin会根据主构造函数中的参数
       将equals()等固定且无实际逻辑意义的方法自动生成。
*/
//当数据类没有任何代码时，还可以将尾部的大括号省略
data class Cellphone(val brand: String, val price: Double)

data class Cellphone2(val brand: String, val price: Double) {
    val system: String = "Android"

    fun printInfo() {
        println("$brand is $price, os is $system")
    }
}
