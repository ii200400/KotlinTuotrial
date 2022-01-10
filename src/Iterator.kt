class Iterator {

}

fun main() {
    // iterator를 사용하여 참고타입의 자료형의 자료들을 하나씩 살펴보자.
    // 테스트를 위한 리스트
    val numbers = listOf("one", "two", "three", "four")

    // 방법 1
    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    // 방법 2
    for (item in numbers) {
        println(item)
    }

    // 방법 3
    numbers.forEach {
        println(it)
    }

    MutableList(5) { 1 }
    List(5) { 2 }
}