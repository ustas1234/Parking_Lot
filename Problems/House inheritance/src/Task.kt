fun main() {
    val uInputRooms = readLine()!!
    var uInputPrice = readLine()!!.toInt()

    when (uInputPrice) {
        in -Int.MAX_VALUE..0 -> uInputPrice = 0
        in 1_000_000..Int.MAX_VALUE -> uInputPrice = 1_000_000
    }

    val house = when (uInputRooms.toInt()) {
        in -Int.MAX_VALUE .. 1 -> Cabin(uInputRooms.toInt(), uInputPrice)
        in 2..3 -> Bungalow(uInputRooms.toInt(), uInputPrice)
        in 4..4 ->Cottage(uInputRooms.toInt(), uInputPrice)
        in 5..7 -> Mansion(uInputRooms.toInt(), uInputPrice)
        in 8..Int.MAX_VALUE -> Palace(uInputRooms.toInt(), uInputPrice)
        else -> House(uInputRooms.toInt(), uInputPrice)
    }

    println(house.totalPrice())
}

open class House(val rooms: Int, val price: Int) {
    fun totalPrice() = price
}

class Cabin(rooms: Int, price: Int, k: Float = 1F) : House(rooms, (price.toFloat()*k).toInt())
class Bungalow(rooms: Int, price: Int, k: Float = 1.2F) : House(rooms, (price.toFloat()*k).toInt())
class Cottage(rooms: Int, price: Int, k: Float = 1.25F) : House(rooms, (price.toFloat()*k).toInt())
class Mansion(rooms: Int, price: Int, k: Float = 1.4F) : House(rooms, (price.toFloat()*k).toInt())
class Palace(rooms: Int, price: Int, k: Float = 1.6F) : House(rooms, (price.toFloat()*k).toInt())