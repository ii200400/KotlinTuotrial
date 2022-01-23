package org.kotlinlang

import kotlin.math.pow

fun main() {
    // 생략되지 않은 람다 표현식
    val add: (Int, Int) -> Int = { x: Int, y: Int -> x+y }
    // 람다식 매개변수의 자료형 생략
    val multiply: (Int, Int) -> Int = { x, y -> x*y }
    // 선언 자료형 생략
    val pow = { x: Int, y: Int -> x.toDouble().pow(y).toInt() }
    // 람다식에 인수 및 반환값이 없는 경우
    val printHello: () -> Unit = { println("Hello!")}
    // 람다식 안에 람다식이 또 있는 경우
    val lambdaInLambda: (Int) -> (Int) -> Int = {
        num ->
        {
            var sum = 0
            for (i in 0 until num) sum += i
            sum
        }
    }

    println(add(1,2))
    println(multiply(3,4))
    println(pow(5,2))
    printHello()
}