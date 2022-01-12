package com.onion.learn.kotlin.delegation

import kotlin.properties.Delegates

class User {
    //Delegates.observable当值发生变化时，其onChange方法的返回值是Unit类型
    var name: String by Delegates.observable("<no name>") { _, old, new ->
        println("$old -> $new")
    }

    /*
        Delegates.vetoable当值发生变化时，其onChange方法的返回值是Boolean类型; 赋值发生在lambda之后，如果Boolean返回为false，
        则赋值流程将被中断。
     */
    var age: Int by Delegates.vetoable(0) { _, old, new ->
        new > old
    }
}

fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"


    println(user.age)
    user.age = 30
    println(user.age)
    user.age = 20
    println(user.age)
}