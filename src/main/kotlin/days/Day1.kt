package days

import kotlin.math.abs

class Day1 : Day(1, "Historian Hysteria") {

    override fun solvePart1(input: List<String>): String {
        val (firstCol, lastCol) = input
            .map {
                it.split("   ").let { (a, b) ->
                    a.toInt() to b.toInt()
                }
            }
            .unzip()
            .let { (first, second) ->
                first.sorted() to second.sorted()
            }

        return firstCol
            .zip(lastCol)
            .sumOf { (a, b) -> abs(a - b) }
            .toString()
    }

    override fun solvePart2(input: List<String>): String {
        val (firstCol, lastCol) = input
            .map { it.split("   ").let { (a, b) -> a.toInt() to b.toInt() } }
            .unzip()
            .let { (first, second) ->
                first.sorted() to second.sorted()
            }

        return firstCol
            .sumOf { element ->
                element * lastCol.count { it == element }
            }
            .toString()
    }
}