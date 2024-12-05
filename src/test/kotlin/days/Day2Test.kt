package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test : AdventOfCodeTest {

    private val day = Day2()
    private val inputFirst =
        """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent().split('\n')

    private val inputSecond =
        """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("2", day.solvePart1(inputFirst))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("4", day.solvePart2(inputSecond))
    }

}