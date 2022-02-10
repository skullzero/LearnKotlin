package com.onion.learn.kotlin.function

/*
    fun是定义函数的关键字，无论定义声明函数，都一定要用fun来声明
    参数声明格式"参数名:参数类型"，Pascal表示定义法
 */
fun main() {
    val num = largerNumber(10, 20)
    println(num)
    println(largerNumber2(20, 30))
    println(largerNumber3(20))

    //如果只想让某个参数使用默认值
    println(sum(1, num3 = 5))

    println(toList("A", "B", "C"))
    println(toList("A", "B", "C", "D"))
    println(toList(1, 2, 3, 4))

    /*
        toList()也可以传递数组，但不能像Java一样直接传递数组。
        需要使用展开运算符*，即在参数前加*，它表示解包数组，能够让数组中的每个元素在函数
        中被当作单独的参数使用。
    */
    val array = arrayOf("A", "B", "C")
    //直接传递对象将打印对象的地址，比如[Ljava.lang.String;@6e8dacdf
    println(toList(array))
    println(toList(*array))
}

/*
    参数括号后的部分是可选的，用于声明该函数会返回什么类型的数据
 */
fun largerNumber(num1: Int, num2: Int): Int {
    return num1.coerceAtLeast(num2)
}

/*
    单表达式函数
    当一个函数只有一行代码时，Kotlin允许不必编写函数体，可以直接将唯一的一行代码写在定义的尾部，中间用
    等号连接即可。
    使用这种语法，return关键字也可以省略
 */
fun largerNumber2(num1: Int, num2: Int): Int = num1.coerceAtLeast(num2)


/*
    默认参数 - 当某参数省略时将采用默认值
*/
fun largerNumber3(num1: Int, num2: Int = 25): Int {
    return num1.coerceAtLeast(num2)
}

fun sum(num1: Int, num2: Int = 2, num3: Int = 3): Int {
    return num1 + num2 + num3
}

/*
    可变参数
    1. 使用vararg修饰
    2. 一般是最后一个参数
    3. 如果不放在最后，后面的参数要使用命名参数传值
*/
fun <T> toList(vararg items: T): List<T> {
    val result = ArrayList<T>()
    for(item in items) {
        result.add(item)
    }

    return result
}