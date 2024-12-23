package com.example.aoc_2024.day1

import java.io.BufferedReader
import java.io.File
import java.io.IOException

fun main() {
    val filePath = "C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day1\\day1.txt"

    try {
        val bufferedReader: BufferedReader = File(filePath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }

        val leftSide = mutableListOf<Int>()
        val rightSide = mutableListOf<Int>()

        val lines = inputString.lines()

        for (line in lines) {
            val trimmedLine = line.trim()
            val numbers = trimmedLine.split("\\s+".toRegex())

            if (numbers.size == 2) {
                try {
                    leftSide.add(numbers[0].toInt())
                    rightSide.add(numbers[1].toInt())
                } catch (e: NumberFormatException) {
                    println("couldn't convert line to number: $line")
                }
            }
        }

        var similarityScore = 0
        for (i in leftSide) {
            //tu cos pomyslec jakby tu elegancko zrobic
        }

        println("similarity score: $similarityScore")

    } catch (e: IOException) {
        println("couldn't read the file: ${e.message}")
    }
}
