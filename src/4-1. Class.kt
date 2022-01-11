// 코틀린에서 클래스를 사용하는 방법들!
// 여기서는 클래스 초기화 방법만을 적어놓았다는 점을 참고하자.

// 클래스에는
// Constructors and initializer blocks (생성자와 초기화)
// Functions (함수)
// Properties (프로퍼티/속성)
// Nested and inner classes (어질러진, 복잡한(?) 내부 클래스)
// Object declarations (객체 선언)
// Inheritance (상속)
// 등등..
// 등 여러가지를 알아야 잘 쓸 수 있는데 코틀린 라이브러리 4장에서 순서대로 다루고 있으므로
// 원하는 내용이 있다면 파일명을 보고 해당 부분을 참고하거나
// https://kotlinlang.org/docs 여기에서 검색하자.

fun main(){
    // 기본적으로 코틀린에서 클래스는 `class`라는 키워드를 이용해서 선언할 수 있다.
    class Person { /*...*/ }

    // 클래스는 기본 생성자와 보조 생성자를 가질 수 있다.
    // `constructor` 키워드를 사용하는데 annotations(어노테이션 ex.@override) 혹은
    // visibility modifiers(가시성 변경자 ex.private, protected, public)이 없다면 생략이 가능하다.
    class Person2 private constructor(Name: String) { /*...*/ }
    class Person3 (Name: String) { /*...*/ }

    // 객체의 초기화는 init 블록 내에 있는 코드가 순서대로 실행되면서 진행된다.
    // 또한 클래스의 바디 부분에서도 초기화가 가능하다.
    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name"

        init {
            println(firstProperty)
        }

        val secondProperty = "Second property: ${name.length}".also(::println)

        init {
            println("Second initializer block that prints ${name.length}")
        }
    }
    // 자바는 new 키워드를 사용하지만 코틀린은 필요가 없다.
    InitOrderDemo("im!")

    // 생성자에서 바로 초기화를 진행할 수도 있으며
    // 쉼표(Trailing commas)를 사용하여 여러 매개변수를 한꺼번에 작성할 수도 있다.
    // 보조 생성자를 생성하여 다른 매개변수만을 지정하고 싶을 때 사용할 수 있다.
    class Person4(
        val name: String = "none",
        val lastName: String = "none",
        var number: Int = 0
    ) {
        var needInit: Int
        init {
            println("$name 이 기본 생성자를 사용")

            needInit = 1
        }

        // 보조 생성자
        constructor(
            name: String,
            lastName: String
        ) : this(name, lastName, number = 1){ // 기본생성자를 상속받고 기본생성자의 초기화 코드를 먼저 부른다.
            println("$name 이 보조 생성자를 사용")

            needInit = 3
        }
    }
    Person4("YS", "IM", 2)
    Person4("YS2", "IM2")
    // 매개변수명를 직접 넣을 수도 있으며 초기값이 지정되어있다면 생략도 가능하다.
    Person4(number = 3)

    // 아래의 클래스를 참고하자!
    // 위와 아래는 같은 의미이며 companion object 명은 생략이 가능하다.
    Person5.someVal
    Person5.CompanionName.someVal
}

// Companion objects, 자바에서 대응하는 키워드는 static 인것 같다.
// 실재로 사용자에게는 별반 다르지 않지만, 전자는 싱글톤 패턴을 클래스에 적용시킨듯한 이름이 인상적이다.
// 적용은 아래와 같다.
class Person5{
    // inner class에서는 사용이 불가하다고 하여 메인 함수 밖에 작성하였다.
    // 이름을 지정하는 것도 가능(디폴트 네임은 Companion)하며 변수와 함수를 포함시킬 수 있지만
    // 여러 개를 만드는 것은 불가능하다!!
    companion object CompanionName{
        val someVal = "변수 저장 가능"
        fun someFun(){ println("함수 저장 가능") }
    }

    // 'Only one companion object is allowed per class' 라는 에러가 뜬다.
//    companion object CompanionName2{
//
//    }
}