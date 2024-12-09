package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day4Test : AdventOfCodeTest {

    private val day = Day4()
    private val input =
        """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("18", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("9", day.solvePart2(input))
    }

}
