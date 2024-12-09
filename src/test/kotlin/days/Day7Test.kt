package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day7Test : AdventOfCodeTest {

    private val day = Day7()
    private val input =
        """
            190: 10 19
            3267: 81 40 27
            83: 17 5
            156: 15 6
            7290: 6 8 6 15
            161011: 16 10 13
            192: 17 8 14
            21037: 9 7 18 13
            292: 11 6 16 20
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("3749", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("11387", day.solvePart2(input))
    }

}
