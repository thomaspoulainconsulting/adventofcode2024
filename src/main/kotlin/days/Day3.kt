package days

class Day3 : Day(3, "Mull It Over") {

    override fun solvePart1(input: List<String>): String {
        return "mul(\\(\\d+,\\d+)\\)".toRegex().findAll(input.first())
            .sumOf { match -> multiply(match.groupValues[1])
            }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        return input.first().split("do()").sumOf {
            val elt = it.split("don't()")

            "mul(\\(\\d+,\\d+)\\)".toRegex().findAll(elt.first())
                .sumOf { match -> multiply(match.groupValues[1])
                }
        }.toString()
    }

    private fun multiply(input: String): Int {
        val (a, b) = input
            .replace("(", "")
            .replace(")", "")
            .split(",")
        return a.toInt() * b.toInt()
    }
}