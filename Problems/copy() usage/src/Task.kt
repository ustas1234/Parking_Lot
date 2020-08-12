import java.util.Scanner

// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val (h, l1, l2, w) = IntArray(4) {input.nextInt()}
 //   println("$h $l1 $l2 $w")
    val box1 = Box(h,l1,w)
    val box2 = box1.copy(length = l2)
    println("Box(height=${box1.height}, length=${box1.length}, width=${box1.width})")
    println("Box(height=${box2.height}, length=${box2.length}, width=${box2.width})")
}