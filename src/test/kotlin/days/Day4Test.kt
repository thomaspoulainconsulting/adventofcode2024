package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day4Test : AdventOfCodeTest {

    private val day = Day4()
    private val inputFirst =
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

    private val inputSecond =
        """
            
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("18", day.solvePart1(inputFirst))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("48", day.solvePart2(inputSecond))
    }

}
