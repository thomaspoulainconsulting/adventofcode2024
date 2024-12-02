package days

import kotlin.math.abs

class Day2 : Day(2, "Red-Nosed Reports") {

    override fun solvePart1(input: List<String>): String {
        return input.count { report ->
            isSafeReport(report.split(" ").map { it.toInt() })
        }.toString()
    }

    private fun isSafeReport(levels: List<Int>): Boolean {
        // Check if first adjacent levels are within 1-3 range
        if (!isAdjacentLevelsClose(levels[0], levels[1])) {
            return false
        }

        // Determine the trend (increasing or decreasing)
        val isIncreasing = levels[0] < levels[1]

        // Validate the report's progression
        for (i in 1 until levels.size - 1) {
            // Check trend consistency
            if ((isIncreasing && levels[i] > levels[i + 1]) ||
                (!isIncreasing && levels[i] < levels[i + 1])) {
                return false
            }

            // Ensure adjacent levels are within 1-3 range
            if (!isAdjacentLevelsClose(levels[i - 1], levels[i]) ||
                !isAdjacentLevelsClose(levels[i], levels[i + 1])) {
                return false
            }
        }

        return true
    }

    private fun isAdjacentLevelsClose(level1: Int, level2: Int): Boolean {
        return abs(level1 - level2) in 1..3
    }



    override fun solvePart2(input: List<String>): String {
        TODO("Not yet implemented")
    }
}