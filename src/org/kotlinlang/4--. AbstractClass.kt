// 공홈에서 추상 클래스에 관한 설명이 너무 적어서 따로 만들었다.
// 아니.. sealed 도 있고 enum도 있는데 왜 abstract class는 따로 있지 않고 class에 붙여서
// 설명도 너무 부족하고 대충 넘겼는지 잘 모르겠다.

package org.kotlinlang

fun main() {
    // 추상 클래스는 추상 함수를 가질 수 있는 클래스이다.
    // 자바의 경우 해당 클래스의 함수는 모두 추상 함수여야 했지만 코틀린은 일반함수도 가질 수 있다.
    abstract class Polygon {
        // 추상함수
        abstract fun draw()
        // 일반함수
        fun printDraw() { println("draw") }
    }

    // 추상 클래스를 상속받으면 포함된 추상 함수들을 모두 구현해야 한다.
    class Rectangle : Polygon() {
        override fun draw() {
            println("override draw")
        }
    }
    Rectangle().draw()
    Rectangle().printDraw()

}