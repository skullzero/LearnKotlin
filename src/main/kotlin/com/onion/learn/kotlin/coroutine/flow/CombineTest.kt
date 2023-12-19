package com.onion.learn.kotlin.coroutine.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val flow1: Flow<Int> = flow {
    repeat(30) { value ->
        delay(1000)
        println("[Flow1]: emitting $value")
        emit(value)
    }
}


private val flow2: Flow<Char> = flow {
    var value = 'A'
    while(true) {
        delay(2000)
        println("[Flow2]: emitting $value")
        emit(value)
        if (value == 'Z') {
            value = 'A'
        } else {
            value += 1
        }
    }
}

private val flow3: Flow<String> = flow {
    val username = listOf("Tom", "Jerry", "Mickey", "Donald")
    for(name in username) {
        delay(2000)
        emit(name)
    }
}

/*
The combine operator waits for all flows to emit at least one value before it starts combining them.
So, the first call of the combine operator's transform block will happen only when all the flows passed to the
combine block have emitted at least a single value.
*/
fun main() {
    runBlocking {
        //combine 2 flows
        val combineFlow: Flow<String> = flow1.combine(flow2) { flow1Value,flow2Value  ->
            println("[when combine], $flow1Value $flow2Value")
            // here is the "transform" block
            "${flow1Value}_${flow2Value}"
        }

//        combineFlow.collect { value ->
//            println("[combineFlow2 collect] $value")
//        }

        //combine multi flows
        val combineFlow2: Flow<String> = combine(flow1, flow2, flow3) { data1, data2, data3 ->
            when(data2) {
                'T' -> if(data3 == "Tom") "match Tom" else "Match T failed"
                'J' -> if(data3 == "Jerry") "match Jerry" else "Match J failed"
                'M' -> if(data3 == "Mickey") "match Tom" else "Match M failed"
                'D' -> if(data3 == "Donald") "match Jerry" else "Match D failed"
                else -> "Not Match"
            }
        }

        combineFlow2.collect { value ->
            println("[combineFlow2 collect] $value")
        }
    }
}