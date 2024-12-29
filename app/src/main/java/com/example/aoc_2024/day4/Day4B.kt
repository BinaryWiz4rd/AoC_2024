package com.example.aoc_2024.day4

import java.io.File
/*
Unfortunately here, the method i used in part A, would not work in part B so actually i had to use
the method that was terrible last year.
 */
fun countXMas(grid: Array<String>): Int {
    val rows = grid.size
    val cols = grid[0].length
    var counter = 0
    var count1found = false
    var count2found = false

    // lece se po naszym gridzie
    for (i in 1 until rows - 1) { //tu disableyujemy ramke, i patrzymy na 'A' co sa w srodku
        for (j in 1 until cols - 1) {

            // tu szukamy 'A'
            if (grid[i][j] == 'A') {
                // patrze na diagonal (top-left to bottom-right)
                if (i - 1 >= 0 && j - 1 >= 0 && i + 1 < rows && j + 1 < cols) {
                    if (grid[i - 1][j - 1] == 'M' && grid[i + 1][j + 1] == 'S' ||
                        grid[i - 1][j - 1] == 'S' && grid[i + 1][j + 1] == 'M') {
                        count1found = true
                    }
                } // tu ten drugi diagonal
                if (count1found == true && i - 1 >= 0 && j + 1 < cols && i + 1 < rows && j - 1 >= 0) {
                    if (grid[i - 1][j + 1] == 'M' && grid[i + 1][j - 1] == 'S' ||
                        grid[i - 1][j + 1] == 'S' && grid[i + 1][j - 1] == 'M') {
                        count2found = true
                    }
                }
                if (count1found==true && count2found==true){
                    counter++
                    count1found = false
                    count2found=false
                }
                else {
                    count1found = false
                    count2found = false
                }
                }
            }
        }
    return counter
}

fun main() {
    val input = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day4\\day4.txt")
        .readLines()
        .map { it.trim() }

    val grid = input.toTypedArray()

    val result = countXMas(grid)

    println("mas in x format appeared $result times")
}
