package org.kotlinlang

fun main() {
    // 코틀린에는 대표적으로 return, break, continue 세 개의 jump 표현식이 있다.

    // return에 의한 jump
    fun jumpReturn() {
        data class Person(val name: String?)

        val personName1 = Person("Im").name ?: "123123"
        println("personName1 : $personName1")
        // null 값을 넣어 return을 하기 때문에 해당 가장 가까운 반복 혹은 함수(jumpReturn)가 끝난다.
        val personName2 = Person(null).name ?: return
        println("이것은 출력되지 않는다.")
    }
    jumpReturn()

    // @을 이용해서 만들 수 있는 label로 break 혹은 continue 하는 지점을 지정할 수 있다.
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            println("j: $j, i: $i")
            if (j == 5) break@loop
        }
    }

    // forEach문은 람다를 사용하기 때문에 for문 처럼 break나 continue를 사용하지 못한다.
    // 대신 아래와 같은 방법을 사용하면 된다.

    // break나 continue은 사용하지 못하지만 return은 사용할 수 있다.
    fun foo1() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return
            print(it)
        }
        println("this point is unreachable")
    }
    foo1()
    println()

    // 함수 내에서 label과 return 을 사용하여 for문 에서의 continue와 같은 코드를 만들 수 있고
    fun foo2() {
        listOf(1, 2, 3, 4, 5).forEach lit@{
            // 람다 내부(forEach loop)에서의 return 을 한다.
            if (it == 3) return@lit
            print(it)
        }
        println(" done with explicit label")
    }
    foo2()

    // 람다식 자체를 하나의 함수로 만들어 continue 와 같은 기능을 만들 수도 있다.
    fun foo3() {
        listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
            if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
            print(value)
        })
        println(" done with anonymous function")
    }
    foo3()
}