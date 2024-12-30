package com.example.aoc_2024.day6

import java.io.File

fun findSign(grid: Array<String>, signs: CharArray): Pair<Int, Int>? {
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] in signs) {
                return Pair(i, j)
            }
        }
    }
    return null
}

fun moveGuard(grid: Array<String>, position: Pair<Int, Int>, sign: Char): Pair<Int, Int> {
    var (row, col) = position

    when (sign) {
        '^' -> if (row > 0) row--
        '>' -> if (col < grid[row].length - 1) col++
        '<' -> if (col > 0) col--
        'v' -> if (row < grid.size - 1) row++
    }

    return Pair(row, col)
}

fun printGrid(grid: Array<String>) {
    for (row in grid) {
        println(row)
    }
}

fun traverse(grid: Array<String>, start: Pair<Int, Int>, signAtStart: Char) {
    var currentLocation = start
    var currentSign = signAtStart
    var gridList = grid.map { it.toCharArray() }.toMutableList()

    var moveCount = 0
    while (true) {
        gridList[currentLocation.first][currentLocation.second] = 'X'

        currentLocation = moveGuard(grid, currentLocation, currentSign)
        // on sie nie rusza, ta petla dziala tylko raz
        //potem dodac zeby mi skrecal bo mi nie skreca, czyli zeby nie drukowal mi println
        if (currentLocation.first < 0 || currentLocation.first >= grid.size ||
            currentLocation.second < 0 || currentLocation.second >= grid[currentLocation.first].length ||
            grid[currentLocation.first][currentLocation.second] == '#') {
            println("guard stopped at: $currentLocation (out of bounds or hit a wall)")
            break
        }

        currentSign = grid[currentLocation.first][currentLocation.second]

        gridList[currentLocation.first][currentLocation.second] = 'G'

        val updatedGrid = gridList.map { it.concatToString() }.toTypedArray()
        println("move #$moveCount:")
        printGrid(updatedGrid)

        moveCount++
        Thread.sleep(500)
    }
}

fun main() {
    val input = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day6\\day6_sample.txt")
        .readLines()
        .map { it.trim() }

    val grid = input.toTypedArray()
    val signs = charArrayOf('^', '>', '<', 'v')

    val initialLocation = findSign(grid, signs)
    if (initialLocation != null) {
        var currentLocation = initialLocation

        println("initial grid:")
        printGrid(grid)
        println("location of Guard: $currentLocation\n")

        val signAtStart = grid[currentLocation.first][currentLocation.second]

        traverse(grid, initialLocation, signAtStart)
    } else {
        println()
    }
}
