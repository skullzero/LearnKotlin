package com.onion.learn.kotlin.classes.extensions

/*
    Kotlin provides the ability to extend a class with new functionality without having to inherit
    from the class or use design patterns such as Decorator.
    关于receiver type的理解，可以参考modulexia的readme

    建议向哪个类中增加扩展函数，就定义一个同名的kotlin文件，便于以后查找；当然扩展函数可以定义在任何一个
    同名的Kotlin文件中，并不一定非要创建新文件。
*/

fun main() {
    val letters = "abcd345abcd"
    println(letters.lettersCount())
}

/*
    To declare an extension function, we need to prefix its name with a receiver type,
    i.e. the type being extended.
    声明一个扩展函数的方法就是在函数名前加上一个receiver类型，也就是要被扩展的类型
*/
fun String.lettersCount(): Int {
    var count = 0;
    for(char in this) {
        if(char.isLetter()) {
            count ++
        }
    }
    return count
}