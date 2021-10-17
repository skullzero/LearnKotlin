package com.onion.learn.kotlin.collection

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