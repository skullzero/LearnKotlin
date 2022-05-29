package com.onion.learn.kotlin.generic

fun main() {
    val printer = Printer<String>()
    printer.setValue("hello")
    printer.print()

    val printer2 = Printer<Int>()
    printer2.setValue(123)
    printer2.print()

    val printer3 = AnotherPrinter<String, Int>()
    printer3.setValue("hello", 100)
    printer3.print()
}

/*
    如果不想接收任何可空类型，可用Any作为类型约束.
    如果不用Any进行类型约束，则thingToPrint无法声明为lateinit
*/
private class Printer <T : Any> {
    private lateinit var thingToPrint : T

    fun setValue(thing: T) {
        thingToPrint = thing
    }

    fun print() {
        println(thingToPrint)
    }
}

private class AnotherPrinter <T : Any, V : Any> {
    private lateinit var thingToPrint : T
    private lateinit var anotherThingToPrint : V

    fun setValue(thing: T, anotherThing: V) {
        thingToPrint = thing
        anotherThingToPrint = anotherThing
    }

    fun print() {
        println("$thingToPrint and $anotherThingToPrint")
    }
}