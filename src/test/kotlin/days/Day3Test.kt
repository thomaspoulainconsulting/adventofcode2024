package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test : AdventOfCodeTest {

    private val day = Day3()
    private val inputFirst =
        """
            xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
        """.trimIndent().split('\n')

    private val inputSecond =
        """
            xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("161", day.solvePart1(inputFirst))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("48", day.solvePart2(inputSecond))
    }

}
