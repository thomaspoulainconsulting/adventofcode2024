package days

class Day4 : Day(4, "Ceres Search") {

    private val xmas = "XMAS"

    override fun solvePart1(input: List<String>): String {
        val directions = listOf(0 to -1, 1 to -1, 1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1)


        return input.flatMapIndexed { y, s ->
            s.mapIndexed { x, c -> x to c }
                .filter { it.second == 'X' }
                .map { it.first to y }
        }.sumOf { p ->
            directions
                .count { o ->
                    xmas.indices.map {
                        input.getOrNull(p.second + it * o.second)
                            ?.getOrNull(p.first + it * o.first) ?: ""
                    }.joinToString("") == xmas
                }
        }.toString()
    }

    override fun solvePart2(input: List<String>): String {
        return input.flatMapIndexed { y, s ->
            s.mapIndexed { x, c -> x to c }
                .filter { it.second == 'A' }.map { it.first to y }
        }.count { p ->
            listOf(
                listOf(-1 to -1, 0 to 0, 1 to 1),
                listOf(1 to -1, 0 to 0, -1 to 1)
            ).map { figure ->
                figure.map { s ->
                    input.getOrNull(p.second + s.second)
                        ?.getOrNull(p.first + s.first) ?: ""
                }.joinToString("").let { it == "MAS" || it == "SAM" }
            }.all { it }
        }.toString()
    }
}