fun reverse(input: Int?): Int {
    var reversedString: String = ""
    if (input != null) {
        val convertedInt = input.toString()

        for (i in convertedInt.indices) {
            reversedString += convertedInt[convertedInt.lastIndex - i]
        }
    } else return -1
    return reversedString.toInt() ?: -1
}

fun main() {
    println(reverse(null))
}