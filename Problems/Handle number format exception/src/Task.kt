import java.lang.Exception

fun parseCardNumber(cardNumber: String): Long {
    val cardInput = cardNumber//readLine()!!
    val wrongCard = Exception()
    if (cardInput.length == 19) {
        for (i in cardInput.indices) {
            if (i == 4 || i == 9 || i == 14) {
                if (cardInput[i] != ' ') throw wrongCard
            } else {
                if (!cardInput[i].isDigit()) throw wrongCard
            }
        }
    } else throw wrongCard
   // val result = (cardInput.substring(0..4) + cardInput.substring(5..8) + cardInput.substring(9..13) + cardInput.substring(14..18))
    val result = cardInput.substring(0,4) + cardInput.substring(5,9) + cardInput.substring(10,14) + cardInput.substring(15,19)
    return result.toLong()
}

/*
fun main() {
    println(parseCardNumber("1234 5678 9012 3456"))
}*/
