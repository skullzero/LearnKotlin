package com.onion.learn.kotlin.collection

/*
1. List is an ordered collection with access to elements by indices – integer numbers that reflect their position.
Elements can occur more than once in a list. An example of a list is a telephone number: it's a group of digits,
their order is important, and they can repeat.

2. Set is a collection of unique elements. It reflects the mathematical abstraction of set: a group of objects
without repetitions. Generally, the order of set elements has no significance. For example, the numbers on
lottery tickets form a set: they are unique, and their order is not important.

3. Map (or dictionary) is a set of key-value pairs. Keys are unique, and each of them maps to exactly one value.
The values can be duplicates. Maps are useful for storing logical connections between objects,
for example, an employee's ID and their position.
*/
fun main() {

    println("listOf---------------------------------------------")
    //listOf()函数用于创建一个不可变的有序集合(ArrayList),
    val fruitList = listOf("Apple", "Banana", "Pear", "Grape")
    for(i in fruitList) {
        println(i)
    }

    println("mutableListOf---------------------------------------------")

    val fruitList2 = mutableListOf("Apple", "Banana", "Pear", "Grape")
    fruitList2.add("Orange")
    for(i in fruitList2) {
        println(i)
    }

    /*
       write operations modify the same mutable collection object, so the reference doesn't change.
       Although, if you try to reassign a val collection, you'll get a compilation error.
    */
    //fruitList2 = mutableListOf("Coconuts", "Strawberry")  // compilation error

    println("setOf---------------------------------------------")
    //Set集合底层是使用hash映射机制来存放数据，因此集合中的元素无法保证有序
    val fruitSet = setOf("Apple", "Banana", "Pear", "Grape")
    for(i in fruitSet) {
        println(i)
    }

    println("map---------------------------------------------")
    val fruitMap = HashMap<String, Int>()
    fruitMap["Apple"] = 1
    fruitMap["Banana"] = 2
    fruitMap["Pear"] = 3
    fruitMap["Grape"] = 4
    fruitMap["Orange"] = 5

    val fruitMap2 = mapOf("Apple" to 1, "Banana" to 2, "Pear" to 3, "Grape" to 4, "Orange" to 5)
    for((fruit, number) in fruitMap2) {
        println("fruit is $fruit, number is $number")
    }
}