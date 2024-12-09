package days

class Day4 : Day(4, "Ceres Search") {

    override fun solvePart1(input: List<String>): String {
        val directions = listOf(0 to -1, 1 to -1, 1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1)
        val xmas = "XMAS"

        return input.indices.sumOf { row ->
            input[row].indices.sumOf { col ->
                directions.count { (dx, dy) ->
                    xmas.indices.all { i ->
                        val (nx, ny) = row + i * dx to col + i * dy
                        nx in input.indices && ny in input[0].indices && input[nx][ny] == xmas[i]
                    }
                }
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