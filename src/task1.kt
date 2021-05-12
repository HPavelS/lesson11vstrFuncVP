import kotlin.contracts.contract

fun main() {
    val cat1 = Cat("1cat")
    val cat2 = Cat("2cat")
    val cat3 = Cat("3cat")
    val catContest = Contest<Cat>()
    catContest.addScore(cat1, 5)
    catContest.addScore(cat2, 10)
    catContest.addScore(cat3, 10)
    println(catContest.getWinners())
}

abstract class Pet(var name: String)
class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)
class Contest<T: Pet>() {
    var scores: MutableMap<T, Int> = mutableMapOf()
    fun addScore(t: T, score: Int = 0) {
        if (score >= 0) scores.put(t, score)
    }
    fun getWinners(): Set<T> {
        val highScore = scores.values.maxOrNull()
        println(highScore)
        val winners = scores.filter { it.value == highScore }.keys
        winners.forEach{ println("Winner: ${it.name}") }
            return winners
    }
}
