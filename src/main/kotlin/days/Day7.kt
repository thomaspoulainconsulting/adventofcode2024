package days

class Day7 : Day(7, "Bridge Repair") {

    data class Equation(val testValue: Long, val numbers: List<Long>)

    override fun solvePart1(input: List<String>): String {
        val equations = parseInput(input)
        val totalCalibrationResult = equations.filter { canBeTrue(it) }.sumOf { it.testValue }
        return totalCalibrationResult.toString()
    }

    private fun parseInput(input: List<String>): List<Equation> {
        return input.map { line ->
            val parts = line.split(": ")
            val testValue = parts[0].toLong()
            val numbers = parts[1].split(" ").map { it.toLong() }
            Equation(testValue, numbers)
        }
    }

    private fun canBeTrue(equation: Equation): Boolean {
        val numOperators = equation.numbers.size - 1
        val operators = generateOperatorCombinations(numOperators)
        return operators.any { evaluate(equation.numbers, it) == equation.testValue }
    }

    private fun generateOperatorCombinations(numOperators: Int): List<List<Char>> {
        val combinations = mutableListOf<List<Char>>()
        generateOperatorCombinations(numOperators, mutableListOf(), combinations)
        return combinations
    }

    private fun generateOperatorCombinations(
        numOperators: Int,
        current: MutableList<Char>,
        combinations: MutableList<List<Char>>
    ) {
        if (current.size == numOperators) {
            combinations.add(current.toList())
            return
        }
        for (op in listOf('+', '*')) {
            current.add(op)
            generateOperatorCombinations(numOperators, current, combinations)
            current.removeAt(current.size - 1)
        }
    }

    private fun evaluate(numbers: List<Long>, operators: List<Char>): Long {
        var result = numbers[0]
        for (i in operators.indices) {
            result = when (operators[i]) {
                '+' -> result + numbers[i + 1]
                '*' -> result * numbers[i + 1]
                else -> throw IllegalArgumentException("Unknown operator: ${operators[i]}")
            }
        }
        return result
    }

    override fun solvePart2(input: List<String>): String {
        val equations = parseInput(input)
        val totalCalibrationResult = equations.filter { canBeTrueWithConcatenation(it) }.sumOf { it.testValue }
        return totalCalibrationResult.toString()
    }

    fun canBeTrueWithConcatenation(equation: Equation): Boolean {
        val numOperators = equation.numbers.size - 1
        val operators = generateOperatorCombinationsWithConcatenation(numOperators)
        return operators.any { evaluateWithConcatenation(equation.numbers, it) == equation.testValue }
    }

    private fun generateOperatorCombinationsWithConcatenation(numOperators: Int): List<List<Char>> {
        val combinations = mutableListOf<List<Char>>()
        generateOperatorCombinationsWithConcatenation(numOperators, mutableListOf(), combinations)
        return combinations
    }

    private fun generateOperatorCombinationsWithConcatenation(numOperators: Int, current: MutableList<Char>, combinations: MutableList<List<Char>>) {
        if (current.size == numOperators) {
            combinations.add(current.toList())
            return
        }
        for (op in listOf('+', '*', '|')) {
            current.add(op)
            generateOperatorCombinationsWithConcatenation(numOperators, current, combinations)
            current.removeAt(current.size - 1)
        }
    }

    private fun evaluateWithConcatenation(numbers: List<Long>, operators: List<Char>): Long {
        var result = numbers[0]
        for (i in operators.indices) {
            result = when (operators[i]) {
                '+' -> result + numbers[i + 1]
                '*' -> result * numbers[i + 1]
                '|' -> (result.toString() + numbers[i + 1].toString()).toLong()
                else -> throw IllegalArgumentException("Unknown operator: ${operators[i]}")
            }
        }
        return result
    }
}