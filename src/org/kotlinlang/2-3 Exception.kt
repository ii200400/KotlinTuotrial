package org.kotlinlang

fun main(){
    // try를 실행하고 문제가 생기면 catch를 실행하고 finally를 그렇지 않으면 바로 finally를 실행한다.
    // 이러한 try-catch 문을 변수 초기화에도 사용할 수 있다.
    print("a: ")
    val a: Int? = try { readLine()?.toInt() } catch (e: NumberFormatException) { null }
    println("a: $a")

    // Nothing 타입
    // throw 표현식은 Nothing 타입이다.
    // 이 타입은 값을 가지는 것이 아니고 해당 위치에 코드가 도달하면 안된다는 의도로 사용된다.
    data class Person(val name: String?)
    val s = Person("im").name ?: throw IllegalArgumentException("Name required")

    // exception 코드에 당도하면 바로 실행되던 프로그램이 종료된다.
    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }
//    fail("exception")

    // 변수에 null을 넣은 경우 추가적인 단서가 없다면 컴파일러는 기본적으로 Nothing? 타입으로 지정한다.
    var x = null
    if (x is Nothing?) println("x is Nothing")
}