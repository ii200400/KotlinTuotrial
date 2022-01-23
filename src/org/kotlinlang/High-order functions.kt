package org.kotlinlang

import kotlin.math.pow

class HighOrderFunction {
    fun add (num1: Int, num2: Int): Int = num1 + num2
    fun multiply (num1: Int, num2: Int): Int = num1 * num2
    fun pow (num1: Int, num2: Int): Int = num1.toDouble().pow(num2).toInt()

    fun calc (num1: Int, num2: Int, op: (Int, Int) -> Int): Int = op(num1, num2)
    fun calcWith2 (op: (Int, Int) -> Int): (Int) -> Int {
        return  { num: Int -> op(num, 2) }
    }

}

fun main() {
    val high = HighOrderFunction()
    val temp = { x:Int, y:Int -> x + y }
    println(high.calcWith2(temp))
    println(high.calcWith2(temp)(2))
}