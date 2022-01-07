package com.onion.learn.kotlin.delegation

/*
    The by for a class is a keyword. This class’ by has the same meaning,
    of provided by (or delegate), but more towards implementation of its functionality.
*/

//A class Derived can implement an interface Base by delegating all of its public members to a specified object
interface Base {
    val message: String
    fun print()
    fun printMessage()
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() {
        println(message)
    }

    override fun printMessage() {
        println(x)
    }
}

//注意，此处需要委托类的实例作为参数
class Derived(b: Base) : Base by b {
    // This property is not accessed from b's implementation of `print`
    override val message = "Message of Derived"

    //the compiler will use override implementations instead of those in the delegate object.
    override fun printMessage() {
        println("abc")
    }
}

fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
    derived.printMessage()
    println(derived.message)
}