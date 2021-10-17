package com.onion.learn.kotlin.scopefunction

/*
    以下以实例来描述不同场景下scope functions的使用建议

    Function	Object reference	Return value	Is extension function
    let	        it	                Lambda result	        Yes
    run	        this	            Lambda result	        Yes
    run	        -	                Lambda result	        No: called without the context object
    with	    this	            Lambda result	        No: takes the context object as an argument.
    apply	    this	            Context object	        Yes
    also	    it	                Context object	        Yes

    Each scope function uses one of two ways to access the context object:
    as a lambda receiver (this) or as a lambda argument (it)

    Here is a short guide for choosing scope functions depending on the intended purpose:
    --->
    Executing a lambda on non-null objects: let
    Introducing an expression as a variable in local scope: let
    Object configuration: apply
    Object configuration and computing the result: run
    Running statements where an expression is required: non-extension run
    Additional effects: also
    Grouping function calls on an object: with
*/
fun main() {

    println("---------------let-----------------")
    /*
        let经常和?.操作符一起，用作为某值为非空时执行一段代码
    */
    val str: String? = "Hello"
    //processNonNullString(str)       // compilation error: str can be null
    val length = str?.let {
        println("let() called on $it")
        processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }

    /*
        let的另一个使用场景是定义一个局部变量来提高代码的可读性，比如下面的firstItem代替了默认的it
    */
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!$firstItem!"
    }.toUpperCase()
    println("First item after modifications: '$modifiedFirstItem'")


    println("---------------with-----------------")
    /*
        with -> "with this object, do the following", 这里的object即receiver object。
        在代码块儿中可以直接操作receiver object的属性或方法
        另不建议在with代码块中提供lambda表达式的结果作为返回值

        with经常被用作Grouping function calls on an object，即with的代码块内罗列执行多个其他函数的调用
    */
    val numbers2 = mutableListOf("one", "two", "three")
    with(numbers2) {
        println("'with' is called with argument $this")
        println("It contains $size elements") //access size without any additional qualifiers
    }


    println("---------------run-----------------")
    /*
        run经常被在lambda代码块中同时存在object初始化和计算返回值的情况
    */
    val service = MultiportService("https://example.kotlinlang.org", "80")
    val runQuery = service.run {
        port = "8080"
        prepreRequest() + " $url with $port"
    }

    // the same code written with let() function:
    val letQuery = service.let {
        it.port = "8080"
        it.prepreRequest() + " ${it.url} with ${it.port}"
    }

    println(runQuery)
    println(letQuery)


    println("---------------apply-----------------")
    /*
        apply通常被用在一个不返回值的代码块上，这个代码块主要用来操作receiver object的成员。
        即apply被用来配置对象，“apply the following assignments to the object.”
    */
    val adam = Person().apply {
        name = "Adam"
        age = "32"
    }
    println(adam.name)


    println("---------------also-----------------")
    /*
    also --> “also do the following with the object.”
    */
    val number3 = mutableListOf("one", "two", "three")
    number3
        .also { println("The list elements before adding new one: $it") }
        .add("four")
    println(number3)
}

fun processNonNullString(str: String) {
    println("processNonNullString-------------------------------$str")
}

class MultiportService(val url: String, var port: String) {
    fun prepreRequest(): String {
        return "request is for "
    }
}

