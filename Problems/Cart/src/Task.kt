fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product(price, productType)
    println(totalPrice(product))
}

open class Product(val price: Int, val type: String)


fun totalPrice (product: Product): Int {
    var res = 0
    when (product.type) {
        "headphones" -> res = (product.price + product.price * 0.11).toInt()
        "smartphone" -> res = (product.price + product.price * 0.15).toInt()
        "tv" -> res = (product.price + product.price * 0.17).toInt()
        "laptop" -> res = (product.price + product.price * 0.19).toInt()
    }
    return res
}