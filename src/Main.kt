fun displayMessage(message: String) = println(message)

/**
 * Represents a lambda expression that calculates the sum of two integers.
 *
 * The `sum` variable stores a lambda expression that takes two integers, `x` and `y`, and returns their sum.
 * It is a shorthand notation for defining a function that performs addition.
 *
 * Example usage:
 * ```kotlin
 * val result = sum(3, 4) // result = 7
 * ```
 *
 * Note:
 * - This lambda expression can only be used with integers.
 */
val sum = { x: Int, y: Int -> x + y }

/**
 * Returns a personalized greeting message by concatenating the string
 * "Hello, " with the current string.
 *
 * @return the personalized greeting message
 */
fun String.greet(): String {
    return "Hello, $this!"
}

/**
 * Performs an operation on two integers and prints the result.
 *
 * @param x the first integer
 * @param y the second integer
 * @param operation the operation to be performed on the integers
 */
inline fun perform(x: Int, y: Int, operation: (Int, Int) -> Int){
    val result = operation(x, y)
    println("Result: $result")
}

/**
 * Constructs a string using the provided builder action.
 *
 * @param builderAction the lambda function to build the string using a StringBuilder receiver object
 * @return the constructed string
 */
fun buildString(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

infix fun Int.add(x: Int) = this + x

class SumBuilder(private val initialValue: Int) {
    private val numbers = mutableListOf<Int>()

    fun add(x: Int): SumBuilder {
        numbers.add(x)
        return this
    }

    fun build(): Int {
        return numbers.fold(initialValue) { sum, element -> sum + element }
    }
}

fun main() {
    val res = buildString {
        append("Numbers: ")
        append("1, 2, 3, 4, 5,")
    }

    val sum2 = 1 add 2

    val sum3 = SumBuilder(0).add(10).add(20).add(20).build()

    println("builder summation $sum3")
    println(sum2)
    println(res)
    perform(1, 2, sum)
    println("summation ${sum(1, 2)}")
    println("Kotlin".greet())
    displayMessage("Hello World!")
}