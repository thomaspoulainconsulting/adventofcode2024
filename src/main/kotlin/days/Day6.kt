package days

import kotlin.math.abs

class Day6 : Day(6, "Guard Gallivant") {

    data class Position(val x: Int, val y: Int)

    enum class Direction {
        UP, RIGHT, DOWN, LEFT
    }

    private fun findGuardStart(map: List<CharArray>): Position {
        for (y in map.indices) {
            for (x in map[y].indices) {
                if (map[y][x] == '^') {
                    return Position(x, y)
                }
            }
        }
        throw IllegalArgumentException("Guard start position not found")
    }

    private fun findObstacles(map: List<CharArray>): Set<Position> {
        val obstacles = mutableSetOf<Position>()
        for (y in map.indices) {
            for (x in map[y].indices) {
                if (map[y][x] == '#') {
                    obstacles.add(Position(x, y))
                }
            }
        }
        return obstacles
    }

    private fun getNextPosition(currentPosition: Position, direction: Direction): Position {
        return when (direction) {
            Direction.UP -> Position(currentPosition.x, currentPosition.y - 1)
            Direction.RIGHT -> Position(currentPosition.x + 1, currentPosition.y)
            Direction.DOWN -> Position(currentPosition.x, currentPosition.y + 1)
            Direction.LEFT -> Position(currentPosition.x - 1, currentPosition.y)
        }
    }

    private fun turnRight(direction: Direction): Direction {
        return when (direction) {
            Direction.UP -> Direction.RIGHT
            Direction.RIGHT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
        }
    }

    override fun solvePart1(input: List<String>): String {
        val map = input.map { it.toCharArray() }
        val guardStart = findGuardStart(map)
        val obstacles = findObstacles(map)
        val visited = mutableSetOf<Position>()
        var currentPosition = guardStart
        var currentDirection = Direction.UP

        visited.add(currentPosition)

        while (true) {
            val nextPosition = getNextPosition(currentPosition, currentDirection)
            if (nextPosition.x !in map[0].indices || nextPosition.y !in map.indices) {
                break // Guard has left the mapped area
            }

            if (obstacles.contains(nextPosition)) {
                currentDirection = turnRight(currentDirection)
            } else {
                currentPosition = nextPosition
                visited.add(currentPosition)
            }
        }

        return visited.size.toString()
    }

    override fun solvePart2(input: List<String>): String {
        val map = input.map { it.toCharArray() }
        val guardStart = findGuardStart(map)
        val obstacles = findObstacles(map)

        val validPositions = mutableSetOf<Position>()

        for (y in map.indices) {
            for (x in map[y].indices) {
                if (Position(x, y) == guardStart) continue // Skip the guard's starting position
                val newObstacles = obstacles.toMutableSet()
                newObstacles.add(Position(x, y))
                if (isGuardStuckInLoop(map, guardStart, newObstacles)) {
                    validPositions.add(Position(x, y))
                }
            }
        }

        return validPositions.size.toString()
    }

    private fun isGuardStuckInLoop(map: List<CharArray>, guardStart: Position, obstacles: Set<Position>): Boolean {
        val visited = mutableSetOf<Pair<Position, Direction>>()
        var currentPosition = guardStart
        var currentDirection = Direction.UP

        while (true) {
            val nextPosition = getNextPosition(currentPosition, currentDirection)
            if (nextPosition.x !in map[0].indices || nextPosition.y !in map.indices) {
                return false // Guard has left the mapped area
            }

            if (obstacles.contains(nextPosition)) {
                currentDirection = turnRight(currentDirection)
            } else {
                currentPosition = nextPosition
                val state = Pair(currentPosition, currentDirection)
                if (visited.contains(state)) {
                    return true // Guard is stuck in a loop
                }
                visited.add(state)
            }
        }
    }
}