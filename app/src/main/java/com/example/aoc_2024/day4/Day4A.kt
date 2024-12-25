package com.example.aoc_2024.day4

import java.io.File

fun main() {
    // Read the grid from a text file
    val input = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day4\\day4_sample.txt")
        .readLines().map { it.trim() }

    val word = "XMAS"
    var count = 0

    val rightRow = 0
    val rightCol = 1
    val leftRow = 0
    val leftCol = -1
    val downRow = 1
    val downCol = 0
    val upRow = -1
    val upCol = 0
    val downRightRow = 1
    val downRightCol = 1
    val upLeftRow = -1
    val upLeftCol = -1
    val downLeftRow = 1
    val downLeftCol = -1
    val upRightRow = -1
    val upRightCol = 1

    for (row in input.indices) {
        for (column in input[row].indices) {
            if (checkWord(input, word, row, column, rightRow, rightCol)) count++
            if (checkWord(input, word, row, column, leftRow, leftCol)) count++
            if (checkWord(input, word, row, column, downRow, downCol)) count++
            if (checkWord(input, word, row, column, upRow, upCol)) count++
            if (checkWord(input, word, row, column, downRightRow, downRightCol)) count++
            if (checkWord(input, word, row, column, upLeftRow, upLeftCol)) count++
            if (checkWord(input, word, row, column, downLeftRow, downLeftCol)) count++
            if (checkWord(input, word, row, column, upRightRow, upRightCol)) count++
        }
    }
    println("XMAS counter: $count")
}

fun checkWord(grid: List<String>, word: String, row: Int, column: Int, rowDirection: Int, columnDirection: Int): Boolean {
    for (i in word.indices) {
        val rowMove = row + i * rowDirection
        val columnMove = column + i * columnDirection

        //tu nie dziala lol
        if (grid[rowMove][columnMove] != word[i]) {
            return false
        }
    }
    return true
}