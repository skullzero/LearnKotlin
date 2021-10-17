package com.onion.learn.kotlin.scopefunction

/*
https://kotlinlang.org/docs/reference/scope-functions.html#scope-functions

The Kotlin standard library contains several functions whose sole purpose is to execute a block of
code within the context of an object. When you call such a function on an object with a lambda
expression provided, it forms a temporary scope. In this scope, you can access the object
without its name. Such functions are called scope functions.
There are five of them: let, run, with, apply, and also.

Basically, these functions do the same: execute a block of code on an object.
What's different is how this object becomes available inside the block and
what is the result of the whole expression.

The scope functions do not introduce any new technical capabilities,
but they can make your code more concise and readable.
*/

fun main() {

    /*
        The scope functions differ by the result they return:
        - apply and also return the context object.
        - let, run, and with return the lambda result.
    */

    println("---------------context object-----------------")
    val p1 = Person().apply {
        /*
            run, with, and apply refer to the context object as a lambda receiver.
            lambda receiver -> https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver
            Hence, in their lambdas, the object is available as it would be in ordinary class functions.
        */
        //可以忽略this来访问类的属性和方法
        name = "Jerry" //等同于this.name
        age = "15" //等同于this.age
        printInfo() //等同于this.printInfo()
    }
    //这里可以看出apply后的代码块只是对这个Person对象进行了各种操作， 最后返回并赋值给p1的还是Person的对象本身
    println("p1 -> $p1")

    /*
        let and also have the context object as a lambda argument. If the argument name
        is not specified, the object is accessed by the implicit default name it.
    */
    val p2 = Person().let {
        //无法像apply等一样省略this来访问类的对象和方法
        it.name = "Lisa"
        it.age = "25"
        it.printInfo()
    }
    //这里可以看出let返回的是lambda的结果，即最后一行的结果
    println("p2 -> $p2")


    //因为返回的是context object, 所以apply和also可以用于对同一个对象的链式函数调用
    println("---------------apply and also return the context object-----------------")
    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }
              .apply {
                add(2.71)
                add(3.14)
                add(1.0) }
              .also { println("Sorting the list") }
              .sort()
    println(numberList)

    println("---------------let, run, and with return the lambda result-----------------")
    val numbers = mutableListOf("one", "two", "three")
    val countEndsWithE = numbers.run {
        add("four")
        add("five")
        count { it.endsWith("e") }
    }
    println("There are $countEndsWithE elements that end with e.")
}

class Person {
    var name = "Tom"
    var age = "20"

    fun printInfo() {
        println("$name is $age years old")
    }
}

