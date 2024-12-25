package com.example.aoc_2024.day1

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import kotlin.math.abs

fun main() {
    // https://kotlinlang.org/docs/kotlin-doc.html#kdoc-syntax
    /**
     * Here we had to search through left and right-hand side of a file, that looked somewhat like
     * this:
     *         3   4
     *         4   3
     *         2   5
     *         1   3
     *         3   9
     *         3   3
     * And look for from the smallest to the highest number in a column.
     * Then (left) - (right) consecutively and we got a distance!
     * We have to sum up all distances.
     *
     * I added a bunch of try-catch things, to ensure, that if we had a different input,
     * it would display a message for a user, to know what to change in the code.
     */

    //https://stackoverflow.com/questions/55182578/how-to-read-plain-text-file-in-kotlin
    val filePath = "C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day1\\day1.txt"

    try {
        val bufferedReader: BufferedReader = File(filePath).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }

        val leftSide = mutableListOf<Int>()
        val rightSide = mutableListOf<Int>()

        val lines = inputString.lines()

        for (line in lines) {
            val trimmedLine = line.trim() //trim whitespace at the end
            val numbers = trimmedLine.split("\\s+".toRegex()) //split by whitespace
            // czemu to nie dziala
            //val numbers = trimmedLine.split(" ") //split by whitespace

            if (numbers.size == 2) {
                try {
                    leftSide.add(numbers[0].toInt())
                    rightSide.add(numbers[1].toInt())
                } catch (e: NumberFormatException) {
                    println("couldn't convert line to number")
                }
            }
        }

        leftSide.sort()
        rightSide.sort()

        // https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.math/abs.html
        var totalDistance = 0
        for (i in leftSide.indices) {
            totalDistance += abs(leftSide[i] - rightSide[i]) //wartosc bezwzgledna abs bo inaczej mi wypluwal ujemne
        }

        println("left side: $leftSide")
        println("right side: $rightSide")
        println("total distance: $totalDistance")

    } catch (e: IOException) {
        println("couldn't read the file: ${e.message}")
    }
}