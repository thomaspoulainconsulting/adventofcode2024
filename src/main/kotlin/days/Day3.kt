package days

class Day3 : Day(3, "Mull It Over") {

    override fun solvePart1(input: List<String>): String {
        return "mul(\\(\\d+,\\d+)\\)".toRegex().findAll(input.first())
            .sumOf {
                val (a, b) = it.groupValues[1]
                    .replace("(", "")
                    .replace(")", "")
                    .split(",")
                a.toInt() * b.toInt()
            }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        return input.first().split("do()").sumOf {
            val elt = it.split("don't()")

            "mul(\\(\\d+,\\d+)\\)".toRegex().findAll(elt.first())
                .sumOf {
                    val (a, b) = it.groupValues[1]
                        .replace("(", "")
                        .replace(")", "")
                        .split(",")
                    a.toInt() * b.toInt()
                }
        }.toString()
    }
}