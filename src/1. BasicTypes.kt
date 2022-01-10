// 코틀린에 있는 원시 타입과 참조 타입 자료형의 종류와 특징을 확인하자.
// 참고 : https://kotlinlang.org/docs/basic-types.html#numbers-representation-on-the-jvm

fun mainType() {
    // 코틀린은 numbers(Byte, Short, Int, Long, Float, Double), character 그리고 boolean
    // 자료형들을 원시타입으로 분류한다.
    // String과 Array 및 사용자 정의 클래스들은 참조타입으로 분류한다.

    val one = 1 // Int
    val threeBillion = 3000000000 // Long
    val oneLong = 1L // Long
    val oneByte: Byte = 1 // Byte

    val pi = 3.14 // Double
//    val one: Double = 1 // Double type 사용하라고 에러가 난다.
    val oneDouble = 1.0 // Double

    val e = 2.7182818284 // Double
    val eFloat1 = 2.7182818284f // Float
    val eFloat3 = 2.7182819684f
    val eFloat2 = 2.7182818684f
    // Float 자료형은 소수점 6~7번째 자리에서 올림이나 버림 등 값이 변할 수 있다.
    println("eFloat1 : $eFloat1")
    println("eFloat2 : $eFloat2")
    println("eFloat3 : $eFloat3")

    // 코틀린은 암시적 자료형 확대 변환이 없다.
    // 각 자료형은 다른 자료형으로 자동으로 변환해주지 않는다.
    // 개인적으로는 코틀린의 안전성을 지향하는 특징으로 자료형이 혼란스럽지 않도록 의도적으로 기능을 넣지 않은 것 같다.
    fun printDouble(d: Double) {
        println("d is $d")
    }

    val i = 1
    val d = 1.0
    val f = 1.0f
    val l = 1L

    printDouble(d)
//    printDouble(i) // 에러: 자료형 mismatch
    printDouble(i.toDouble())
//    printDouble(f) // 에러: 자료형 mismatch
    printDouble(f.toDouble())

    // 위의 이유로 오버스택이 일어나는 것을 주의해야한다.
    // 값의 오버플로우가 감지되어도 자동으로 바꿔주지는 않는다.
    println("Int.MAX_VALUE : ${Int.MAX_VALUE}")
    println("Overflow : ${Int.MAX_VALUE+1}")

    // 하지만 숫자 관련 자료형들끼리 연산을 할 시에는
    // 대부분의 경우 적절하게 자료형이 지정되기 때문에 결과값의 자료형을 명시할 필요가 없다.
    val isDouble = i + d // Double
    val isDouble2 = d + f // Double
    val isFloat = i + f // Float
    val isLong = i + l // Long

    // 같은 자료형끼리 연산할 시에는 결과값도 언제나 같은 자료형이다.
    val x = 5 / 2
    println("x == 2 : ${x == 2}")

    val xL = 5L / 2
    println("xL == 2L : ${xL == 2L}")

    val xD = 5 / 2.toDouble()
    println("xD == 2.5 : ${xD == 2.5}")

    // _로 가독성 있는 상수값을 쓸 수 있다.
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    // 원시타입으로 분류되는 자료형들은 함수에 값을 넘길 때
    // 가지고 있는 값을 그대로 복사한다.
    fun plus(num: Int) {
        num + 1
    }

    val alwaysOne = 1
    println("before : $alwaysOne")
    plus(alwaysOne)
    println("after : $alwaysOne")

    // nullable 자료형(Int?, Double? 등)을 만들거나 generics을 사용한다면
    // 해당 자료형에 매칭되는 자바의 참조타입으로 boxing 된다. (Int -> Integer, Double)
    // JVM이 Integer에 적용하는 최적화로 인하여 -128 ~ 127 사이의 Integer 객체는 같은 객체이다.
    val a = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println("boxedA and anotherBoxedA is same object? ${boxedA === anotherBoxedA}") // true
    println("boxedB and anotherBoxedB is same object? ${boxedB === anotherBoxedB}") // false
    println("boxedB and anotherBoxedB is same value? ${boxedB == anotherBoxedB}") // true

    // boxing된 원시타입들은 정수가 같아도 다른 값으로 취급된다.
    val boxedInt: Int? = 1 // java.lang.Integer
    val boxedLong: Long? = 1L // java.lang.Long
    // 물론 단순한 원시타입끼리는 비교도 안된다.
    val justInt = 1
    val justLong = 1L

    // false, 값을 확인하는 것 뿐만 아니라 같은 자료형인지도 확인하기 때문
    println("boxedInt value is not same boxedLong : ${b == a}")
    // 비교 불가..
    println("justInt is not Operate '==' with justLong")

    // 박싱에 의해 일치하지 않을 줄 알았는데..
    // 위에서 JVM이 Integer에 적용하는 최적화와 같은 원리일지도 모르겠다.
    val bool = true
    val boolNull: Boolean? = bool
    println("bool 과 boolNull은 같은 객체?: ${bool===boolNull}")

    val char = 'a'
    val charNull: Char? = char
    println("cha이루마군 220화r 과 charNull은 같은 객체?: ${char===charNull}")

    // 참조타입은 대표적으로 String과 Array가 있다.
    // String은 쌍따옴표로 감싸서 표현하며 immutable한 객체이다.

    val str = "abcd"
    println("str.uppercase() : ${str.uppercase()}") // 새로운 String객체를 만들고 출력한다.
    println("str : $str") // 원래 String 객체는 그대로 남아있다.

    // String 객체가 앞에 나오기만 하면 뒤에 어떤 자료형이 나와도 연결된다.
    val s = "abc" + 1
    println("s: $s")
    println("s+\"def\" : ${s + "def"}")
    println("s: $s")

    // Array는 평소 했던 대로 초기화를 진행하면 된다.
    // 단순히 Int를 넣어도 내부에서 자동으로 Integer로 Boxing 되어
    val array1 = Array(5){ 1 }
    val array2 = arrayOf(1,2,3,4,5)

    // 참조타입이기 때문에 얕은 복사에 주의해야 한다.
    // 참조타입의 특징 상 함수 내에서 일어난 일이 함수 밖에서도 영향을 끼치기 때문이다.
    fun arrayPlus(array: Array<Int>) { array[0] += 1 }
    println("array1 defore fun: ${array1.contentDeepToString()}")
    arrayPlus(array1)
    println("array1 after fun: ${array1.contentDeepToString()}")

    // boxing 오버해드를 줄이는 원시타입에 대한 array를 표현하는 방법도 존재한다.
    // ByteArray, ShortArray, IntArray 등이 해당되는데
    // 일반 Array와 뭐가 다르다는지 잘 모르겠다..
}