package days

import AdventOfCodeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day6Test : AdventOfCodeTest {

    private val day = Day6()
    private val input =
        """
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
        """.trimIndent().split('\n')


    @Test
    override fun solvePart1Test() {
        assertEquals("41", day.solvePart1(input))
    }

    @Test
    override fun solvePart2Test() {
        assertEquals("123", day.solvePart2(input))
    }

}
