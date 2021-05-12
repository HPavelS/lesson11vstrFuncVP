fun main() {
    val groceries = listOf(Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2))
    println(groceries.filter { it.category == "Vegetable" }.sumByDouble { it.unitPrice * it.quantity })

    println(groceries.filter { it.unitPrice * it.quantity < 5 }.map { it.name })

    groceries.groupBy { it.category }.forEach {
        println("${it.key}: ${it.value.sumByDouble { it.unitPrice * it.quantity }}")

    }

    groceries.filterNot { it.unit == "Bottle" }.groupBy { it.unit }.forEach{
        println(it.key)
        it.value.forEach{ println("   ${it.name}")}
    }
}

data class Grocery(val name: String, val category: String,
                   val unit: String, val unitPrice: Double,
                   val quantity: Int)
