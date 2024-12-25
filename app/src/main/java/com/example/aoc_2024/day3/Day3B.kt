package com.example.aoc_2024.day3

import java.io.File

fun main() {
    /*
    same but if we have do(), then calculate what's after this, and if you have don't(), don't
     */
    val input = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day3\\day3.txt")
    val readInput = input.readText()

    val regex = Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")

    var totalSum = 0
    var isEnabled = true
    val matches = regex.findAll(readInput)

    for (match in matches) {
        when {
            match.value == "do()" -> {
                isEnabled = true
            }
            match.value == "don't()" -> {
                isEnabled = false
            }
            match.value.startsWith("mul") && isEnabled -> {
                val x = match.groupValues[1].toInt()
                val y = match.groupValues[2].toInt()
                totalSum += x * y
            }
        }
    }

    println("total sum: $totalSum")
}
