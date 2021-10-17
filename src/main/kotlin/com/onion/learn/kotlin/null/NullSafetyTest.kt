package com.onion.learn.kotlin.`null`

/*
    1. kotlin利用编译时判空检查机制几乎杜绝了空指针异常
    2. kotlin默认所有的参数和变量不能为空
    3. 如果某些情况下非要使用到kong参数或变量，kotlin提供了一套可为空的类型判断，只不过在使用可为空的类型系统时，
       我们需要在编译时期就将所有潜在的空指针异常都处理掉，否则代码将无法编译通过
*/
fun main() {
    //由于kotlin默认所有参数和变量都不可为空，且没有启用可空系统，下面一行的代码将无法通过编译
    //driveCar(null)

    driveCar2(null)

}

fun driveCar(car: Car) {
    car.drive()
}

/*
    在类名后加上一个问号。
    比如Int表示不可为空的整型，Int?就表示可以为空的整型
*/
fun driveCar2(car: Car?) {
    /*
        由于可以传入空值，就要把可能异常处理一下，即使用 ?. 操作符来达到如下的效果
        if(car != null) {
            car.drive()
        }
    */
    car?.drive()

    /*
        如果确定不会是空值，后果自己承担的话，则可以使用操作符 !!.
    */
    car!!.drive()
}

class Car {
    fun drive() {
        println("driving")
    }
}