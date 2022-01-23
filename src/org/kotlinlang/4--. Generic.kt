// 가변인수와 같이 쓰면 toList와 비슷한 함수도 만들 수 있다.
//fun <T> asList(vararg ts: T): List<T> {
//    val result = ArrayList<T>()
//    for (t in ts) // ts is an Array
//        result.add(t)
//    return result
//}
//val list = asList(1, 2, 3)

package org.kotlinlang