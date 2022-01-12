package com.onion.learn.kotlin.delegation

/*
    1. A property can delegate its getter and setter to another property.
    2. To delegate a property to another property, use the :: qualifier in the delegate name.
    3. This may be useful, for example, when you want to rename a property in a backward-compatible way:
    introduce a new property, annotate the old one with the @Deprecated annotation, and delegate its implementation.
*/
class MyClass {
    var newName: Int = 0
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

fun main() {
    val myClass = MyClass()
    // Notification: 'oldName: Int' is deprecated.
    // Use 'newName' instead
    myClass.oldName = 42
    println(myClass.newName) // 42
}