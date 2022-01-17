package com.onion.learn.kotlin.collection

import java.util.*

fun main() {
    /*
        map函数
        集合中的map函数是最常用的一中函数式API，它用于将集合中的每个元素都映射成一个另外的值，映射的规则
        在lambda表达式中指定，最终生成一个新的集合
    */
    println("------------------------------------map------------------------------------")
    val fruitList = listOf("Apple", "Banana", "Pear", "Grape", "Orange")
    val newFruitList = fruitList.map { it.uppercase(Locale.getDefault()) }
    for(i in newFruitList) {
        println(i)
    }

    /*
        filter/filterNot函数
        用来过滤集合中的数据，可以单独使用，也可以配合map使用
    */
    println("------------------------------------filter------------------------------------")
    val newFruitList2 = fruitList.filter { it.length > 4 }
    for(i in newFruitList2) {
        println(i)
    }

    println("------------------------------------filter + map------------------------------------")
    val newFruitList3 = fruitList.filter { it.length > 4 }
                                    .map { it.uppercase(Locale.getDefault()) }
    for(i in newFruitList3) {
        println(i)
    }

    println("------------------------------------filterNot------------------------------------")
    val newFruitList4 = fruitList.filterNot { it.length > 4 }
    for(i in newFruitList4) {
        println(i)
    }

    println("------------------------------------any------------------------------------")
    //any函数用于判断集合中是否至少存在一个元素满足指定条件
    val anyResult = fruitList.any { it.length <= 5 }
    println("anyResult is $anyResult")

    println("------------------------------------all------------------------------------")
    //all函数用于判断集合是否所有元素都满足指定条件
    val allResult = fruitList.all { it.length <= 5 }
    println("allResult is $allResult")

    println("------------------------------------map on Object------------------------------------")
    val customerList = listOf(Customer("Tom", 10), Customer("Jerry", 9))
    val newCustomerList = customerList.map {
        //最后一句是转换的最终被采纳的规则
        it.age
        it.name
        "Hello"
    }
    println(newCustomerList)
}

data class Customer (
    val name: String,
    val age: Int
)