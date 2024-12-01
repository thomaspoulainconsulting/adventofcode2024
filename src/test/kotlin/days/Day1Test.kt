package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test : AdventOfCodeTest {

    private val day = Day1()
    private val inputFirst =
        """
        """.trimIndent().split('\n')

    private val inputSecond =
        """
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("142", day.solvePart1(inputFirst))
    }

    @Test
    override fun solvePart2Test() {
        TODO()
    }

}