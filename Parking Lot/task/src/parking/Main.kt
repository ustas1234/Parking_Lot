package parking

class ParkingLot {
    enum class States(val color: String) {
        FREE("Free"),
        BUSY("Busy"),
    }

    var state = States.FREE
    var regNum = "null"
    var color = "null"

    fun carGoing(carRegNum: String, carColor: String): String {
        var result: String
        if (carRegNum.contains(' ')) {
            result = "Registration number invalid!"
        } else {
            color = carColor
            regNum = carRegNum
            state = States.BUSY
            result = "${color} car parked"
        }
        // println(result)
        return result
    }

    fun carLeaving() {
        this.state = States.FREE
    }


}

var numOfSpots = 0
var parkingArea = Array(numOfSpots) { ParkingLot() }


fun main() {


    do {
        val uInput = readLine()!!.split(' ')

        if (parkingArea.isNotEmpty() || uInput[0] == "create" || uInput[0] == "exit") {
            when (uInput[0]) {
                "status" -> viewStatusOfParkingArea()
                "create" -> {
                    createParkingArea(uInput[1].toInt())
                }
                "park" -> {

                    if (checkForFreeSpot()) {
                        val numOfFreeSpot = firstFreeSpot()
                        //parkingArea[numOfFreeSpot].carGoing(uInput[1], uInput[2])
                        println(parkingArea[numOfFreeSpot].carGoing(uInput[1], uInput[2]) + " in spot ${numOfFreeSpot + 1}.")

                    } else println("Sorry, the parking lot is full.")

                }
                "leave" -> {

                    parkingArea[uInput[1].toInt() - 1].carLeaving()
                    println("Spot ${uInput[1].toInt()} is free.")

                }
            }
        } else println("Sorry, a parking lot has not been created.")

    } while (uInput[0] != "exit")
}

fun viewStatusOfParkingArea() {
    var isParkingAreaEmpty = true
    for (i in parkingArea.indices) {
        if (parkingArea[i].state == ParkingLot.States.BUSY) {
            println("${i + 1} ${parkingArea[i].regNum} ${parkingArea[i].color}")
            isParkingAreaEmpty = false
        }
    }
    if (isParkingAreaEmpty) println("Parking lot is empty.")
}

fun createParkingArea(numOfSpots: Int) {
    parkingArea = Array(numOfSpots) { ParkingLot() }
    println("Created a parking lot with $numOfSpots spots.")
}

fun firstFreeSpot(): Int {
    var res = 0
    for (i in parkingArea.indices) {
        if (parkingArea[i].state == ParkingLot.States.FREE) {
            res = i
            break
        }
    }
    // println("first free slot is $res")
    return res
}

fun checkForFreeSpot(): Boolean {
    var result = false
    for (i in parkingArea.indices) {
        if (parkingArea[i].state == ParkingLot.States.FREE) {
            result = true
            break
        }
    }
    // println ("have a free spots: $result")
    return result
}
