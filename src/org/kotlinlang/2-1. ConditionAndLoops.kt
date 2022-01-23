// 코틀린의 Control Flow 에 있는
// 'Conditions and loops', 'Returns and jumps', 'Exceptions'를 순서대로 정리하였다.
// 본인이 모르는 내용을 중점으로 서술하였다.
// 참고 : https://kotlinlang.org/docs/control-flow.html

package org.kotlinlang

import java.lang.Exception

enum class Bit {
    ZERO, ONE, TWO, THREE
}

fun main() {
    // C언어에서는 switch와 비슷한 when 문법부터 작성하겠다.
    // 기본적으로 아래와 같이 작성한다.
    print("x(Int) :")
    val x = readLine()?.toInt()
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> {
            println("x는 1이나 2가 아니다.")
        }
    }

    // 조건 분기에 표현식을 넣는 것도 가능하다.
    print("str(Int) :")
    val str = readLine()
    when (x) {
        str?.toInt() -> println("s와 x는 같다.")
        else -> println("s와 x는 같지 않다.")
    }

    // in이나 !in으로 값이 특정 범위나 컬랙션에 들어가는지를 조건 분기로 할 수도 있다.
    val validNumbers = arrayOf(11, 12, 13, 14)
    when (x) {
        in 1..10 -> println("x는 1~10 내에 있다.")
        in validNumbers -> println("x는 유효값이다.(11~14)")
        !in 15..20 -> println("x는 생각하는 범위 밖에 있다.(~0/20~)")
        else -> println("위의 그 어느 범위에도 들어가지 않는다.(15~19)")
    }

    // enum 클래스를 사용할 수도 있다, 해당 클래스에 관한 내용은 나중에 서술한다.
    val byte = Bit.ZERO
    val numericValue = when (byte) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
        Bit.TWO, Bit.THREE -> -1
        // Bit의 모든 가능한 값을 썼다고(exhaustive) else는 필요없다고 나온다.
        else -> throw Exception("error!")
    }
    println("numericValue : $numericValue")

    // 자료형 확인에도 사용한다.
    print("s: ")
    val s = readLine()!!
    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }
    println("s start with 'prefix'? : ${hasPrefix(s)}")

    // 아래와 같이 특정 클래스의 람다식 내에서 사용할 수도 있다.
//    fun Request.getBody() =
//        when (val response = executeRequest()) {
//            is Success -> response.body
//            is HttpError -> throw HttpException(response.status)
//        }
}