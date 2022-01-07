package com.onion.learn.kotlin.delegation

import kotlin.reflect.KProperty

/*
    where “by” is just a short form of “provided by”.
    Or in another word, “delegate” the generation (or setting) of the value to something else.
*/
fun main() {
    println("---------customer1---------")
    val customer1 = Customer()
    println(customer1.age)
    customer1.age = 20
    println(customer1.age)

    println("---------customer2---------")
    val customer2 = Customer2()
    customer2.name = "Tom"
    customer2.gender = "male"

}

/*
    如果想在多个类中实现同样的功能，就需要把复制大量类似的样本代码(boilerplate codes)
*/
class Customer {
    var age: Int = 10
        get() {
            println("Get age of $field")
            return field
        }
        set(value: Int) {
            println("Set age from $field with $value")
            field = value
        }
}

/*
    属性委托可以使用来自另一个类的属性来替换当前属性的getter和setter。
    换句话说，就是一个类的属性值的操作不再依赖于自身的setter和getter方法，而是将其委托给一个代理类，
    从而每个使用类的该属性可以通过代理类统一管理。
*/
class Customer2 {
    /*
        If one just provide the getValue, then the value can only be val.
        If one provides both getValue and setValue, then the value can be var.
    */
    var name: String by People()
    var gender: String by People()
}

/*
    1. thisRef must be the same type as, or a supertype of, the property owner (for extension properties,
       it should be the type being extended).
    2. property must be of type KProperty<*> or its supertype.
    3. getter/setter前用operator修饰
*/
class People {
    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ): String {
        println("Get ${property.name} of $thisRef")
        return "${property.name}: $thisRef"
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: String) {
        println("Set ${property.name} with $value")
    }
}