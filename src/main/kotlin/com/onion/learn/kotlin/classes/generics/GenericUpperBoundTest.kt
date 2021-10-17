package com.onion.learn.kotlin.classes.generics

/*
    Upper Bound(上界), 泛型上界用来对泛型的类型进行约束。
*/
fun main() {
    println("Int " + GenericUpperBound().getNumber(1))
    println("Float " + GenericUpperBound().getNumber(2f))
    println("Double " + GenericUpperBound().getNumber(3.0))
    //Below line will hit error: is not satisfied: inferred type String is not a subtype of Number
    //println("String " + GenericUpperBound().getNumber("4"))

    println("Nullable " + GenericUpperBound().getNullableNubmer(null))

    //因为getNumber2被定义为 T:Any，则不可以传入null
    //println("Not Nullable" + GenericUpperBound().getNubmer2(null))
}

class GenericUpperBound {
    /*
        下面方法的泛型被定义为Number类型，那么只能传入Int, Float, Double等Number的子类型。
    */
    fun <T: Number> getNumber(param: T): T {
        return param
    }

    /*
        默认情况下，所有的泛型都是可以定义为可空类型的，因为在不手动指定上界的时候，
        泛型的默认上界为 Any?
    */
    fun <T> getNullableNubmer(param: T): T {
        return param
    }

    /*
        如果需要泛型的类型不可为空，只需将泛型的上界定义为 Any 就可以了
    */
    fun <T: Any> getNubmer2(param: T): T {
        return param
    }
}