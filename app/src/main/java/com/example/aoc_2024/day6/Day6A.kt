package com.example.aoc_2024.day6

fun day6A(map: Array<String>, startRow: Int, startCol: Int, startDir: Char): Int {

    val visited = mutableSetOf<Pair<Int, Int>>()

    var currentRow = startRow
    var currentCol = startCol
    var currentDir = startDir

    var step = 0

    // nasz guard nie moze wylezc z mapy, wiec robimy puki jest w niej
    while (currentRow in map.indices && currentCol in map[0].indices) {

        visited.add(Pair(currentRow, currentCol))

        // patrzymy czy moze wlezc, czy moze jest tam '#'
        when (currentDir) {
            '^' -> if (currentRow > 0 && map[currentRow - 1][currentCol] == '#') currentDir = '>'
            // jesli tam jest, to prawo i tak dalej
            '>' -> if (currentCol < map[0].length - 1 && map[currentRow][currentCol + 1] == '#') currentDir = 'v'
            'v' -> if (currentRow < map.size - 1 && map[currentRow + 1][currentCol] == '#') currentDir = '<'
            '<' -> if (currentCol > 0 && map[currentRow][currentCol - 1] == '#') currentDir = '^'
        }

        // tu jest przemieszczenie sie (jesli jest within bounds)
        when (currentDir) {
            '^' -> if (currentRow > 0) currentRow -= 1
            '>' -> if (currentCol < map[0].length - 1) currentCol += 1
            'v' -> if (currentRow < map.size - 1) currentRow += 1
            '<' -> if (currentCol > 0) currentCol -= 1
        }

        step++

        // pomyslec jak to naprawic, bo inaczej nie robi mi outputu
        if (step > 1000) {
            break
        }
    }
    return visited.size
}

fun main() {
    val map = arrayOf(
        "....#.....",
        ".........#",
        "..........",
        "..#.......",
        ".......#..",
        "..........",
        ".#..^.....",
        "........#.",
        "#.........",
        "......#..."
    )

    // szukamy starter pointu (marked with '^')
    var startRow = -1
    var startCol = -1
    var startDir = '^'
    for (row in map.indices) {
        for (col in map[row].indices) {
            if (map[row][col] == '^') {
                startRow = row
                startCol = col
                startDir = '^'
                break
            }
        }
        if (startRow != -1) break
    }

    val result = day6A(map, startRow, startCol, startDir)
    println("amount of guard's visiting districts: $result")
}

// inspiracja do poprawki bledow
//package com.example.aoc_2024.day6
//
//fun day6A(map: Array<String>, startRow: Int, startCol: Int, startDir: Char): Int {
//    val visited = mutableSetOf<Pair<Int, Int>>()
//    var currentRow = startRow
//    var currentCol = startCol
//    var currentDir = startDir
//
//    // Direction vectors for '^', '>', 'v', '<'
//    val directionVectors = mapOf(
//        '^' to Pair(-1, 0),
//        '>' to Pair(0, 1),
//        'v' to Pair(1, 0),
//        '<' to Pair(0, -1)
//    )
//
//    // Direction order for turning right
//    val directions = listOf('^', '>', 'v', '<')
//
//    while (currentRow in map.indices && currentCol in map[0].indices) {
//        visited.add(Pair(currentRow, currentCol))
//
//        // Check for obstacle in front
//        val (deltaRow, deltaCol) = directionVectors[currentDir]!!
//        if (currentRow + deltaRow in map.indices && currentCol + deltaCol in map[0].indices &&
//            map[currentRow + deltaRow][currentCol + deltaCol] == '#') {
//            // Turn right
//            currentDir = directions[(directions.indexOf(currentDir) + 1) % 4]
//        } else {
//            // Move forward
//            currentRow += deltaRow
//            currentCol += deltaCol
//        }
//    }
//
//    return visited.size
//}
//
//fun main() {
//    val map = arrayOf(
//        "....#.....",
//        ".........#",
//        "..........",
//        "..#.......",
//        ".......#..",
//        "..........",
//        ".#..^.....",
//        "........#.",
//        "#.........",
//        "......#..."
//    )
//
//    // Find the starting point
//    var startRow = -1
//    var startCol = -1
//    for (row in map.indices) {
//        for (col in map[row].indices) {
//            if (map[row][col] == '^') {
//                startRow = row
//                startCol = col
//                break
//            }
//        }
//        if (startRow != -1) break
//    }
//
//    val result = day6A(map, startRow, startCol, '^')
//    println("Amount of guard's visiting districts: $result")
//}

