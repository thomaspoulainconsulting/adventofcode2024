package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test : AdventOfCodeTest {

    private val day = Day1()
    private val inputFirst =
        """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent().split('\n')

    private val inputSecond =
        """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("11", day.solvePart1(inputFirst))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("31", day.solvePart2(inputSecond))
    }

}