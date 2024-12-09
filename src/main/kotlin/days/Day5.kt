package days

class Day5 : Day(5, "Print Queue") {

    private fun getRules(input: List<String>) : List<Pair<Int,Int>> =
        input.takeWhile { it.isNotEmpty() && '|' in it }
            .map { it.split("|").let { it[0].toInt() to it[1].toInt() } }

    private fun getUpdates(input: List<String>): List<List<Int>> =
        input.dropWhile { it.isEmpty() || '|' in it }
            .map { it.split(",").map { it.toInt() } }

    override fun solvePart1(input: List<String>): String {
        val rules = getRules(input)
        val updates = getUpdates(input)

        return updates.mapNotNull { pages ->
            val applicableRules = rules.filter { it.first in pages && it.second in pages }
            if (applicableRules.all { (before, after) ->
                    pages.indexOf(before) < pages.indexOf(after)
                }) pages[pages.size / 2] else null
        }.sum().toString()
    }

    override fun solvePart2(input: List<String>): String {
        val rules = getRules(input)
        val updates = getUpdates(input)

        var totalSum = 0
        for (update in updates) {
            if (!isValidUpdate(update, rules)) {
                val sortedUpdate = topologicalSort(update, rules)
                totalSum += sortedUpdate[sortedUpdate.size / 2]
            }
        }
        return totalSum.toString()
    }

    private fun isValidUpdate(update: List<Int>, rules: List<Pair<Int, Int>>): Boolean {
        val updateSet = update.toSet()
        for ((x, y) in rules) {
            if (x in updateSet && y in updateSet) {
                if (update.indexOf(x) > update.indexOf(y)) {
                    return false
                }
            }
        }
        return true
    }

    private fun topologicalSort(update: List<Int>, rules: List<Pair<Int, Int>>): List<Int> {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val inDegree = mutableMapOf<Int, Int>()

        for ((x, y) in rules) {
            if (x in update && y in update) {
                graph.computeIfAbsent(x) { mutableListOf() }.add(y)
                inDegree[y] = inDegree.getOrDefault(y, 0) + 1
            }
        }

        val queue = ArrayDeque<Int>()
        for (page in update) {
            if (inDegree.getOrDefault(page, 0) == 0) {
                queue.add(page)
            }
        }

        val sortedOrder = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            sortedOrder.add(current)
            for (neighbor in graph.getOrDefault(current, mutableListOf())) {
                inDegree[neighbor] = inDegree[neighbor]!! - 1
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        return sortedOrder
    }
}