// 코틀린 공홈에서는 class부터 설명을 하는데 아무리봐도 함수부터 진행하는 것이 더 원활할 것 같아
// class 정리하는 도중에 function부터 진행하려고 한다.
// 어차피 한번씩은 다 간단히 실습을 할 예정이니 상관은 없겠지만..

// 해당 파트에는 function, lambda, inline functions, operator overloading 이 있다.
// 이 파일은 함수(function)에 대한 파일이다.
// 내용 참고는 https://kotlinlang.org/docs/functions.html

package org.kotlinlang

fun main(){
    // 기본적인 함수 작성 방법은 아래와 같다.
    fun double(intParameter: Int): Int {
        return 2 * intParameter
    }

    // 함수 내의 파라미터는 기본값을 지정하는 것이나 람다함수, 가변인수(vararg)를 넣는 것도 가능하다.
    // 단 가변인수는 함수의 인수에 한번씩만 들어갈 수 있다.
    // 람다함수는 3-2를 보자.
    fun foo(
        bar: Int = 0,
        baz: Int,
        bax: (Int) -> Int,
        vararg arg: Int = intArrayOf(1,2)
    ) {
        println("bar: $bar")
        println("baz: $baz")
        println("bax: ${bax(1)}")
    }
    foo(baz = 1, arg = arrayOf(1,2,3).toIntArray(), bax = { i -> i * 2 })
    // 가변인수가 마지막 인수라면 이처럼 표현도 가능하다.
    foo(1,2, { i -> i * 3 }, 1,2,3)
    // 변수를 통해 넣는다면 spread(접두사 '*'로 표현)을 사용한다. (아무리 봐도 포인터라는 느낌인데..)
    val arg = intArrayOf(1,2,3)
    foo(1,2, { i -> i * 3 }, *arg)

    // 단일 표현식(Single-expression)
    // 함수가 단일 표현식을 반환할 때 중괄호를 생략할 수 있으며 내용은 '=' 기호 뒤에 들어간다.
    fun double2(x: Int): Int = x * 2
    // 컴파일러가 충분히 추론 가능하다면 return 자료형을 생략할 수 있다.
    fun double3(x: Int) = x * 2

}