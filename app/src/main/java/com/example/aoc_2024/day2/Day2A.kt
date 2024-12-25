package com.example.aoc_2024.day2

import java.io.BufferedReader
import java.io.File
import java.io.IOException

fun main() {
    /*
    Here, we check each line, and look whether the adjacent numbers are decreasing and increasing,
    and if so, they must do that by 1, 2 or 3.

    Forstly i split the input by whitespaces, and convert it into a list of integers.
         */

    try {
        val bufferedReader: BufferedReader = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\day2\\day2.txt")
            .bufferedReader()
        var safeCount = 0

        bufferedReader.forEachLine { line ->
            // here, i split the line into numbers and convert them into a list of integers
            val report = line.split(" ").map { it.toInt() }

            if (isItSafe(report)) {
                safeCount++
            }
        }

        println("amount of safe reports: $safeCount")
    } catch (e: IOException) {
        println("couldn't read the file: ${e.message}")
    }
}
fun isSafe(report: List<Int>): Boolean {
    /*
    Here i check each element one by one, anc check if the difference between this element and the
    previous one is equal 1, 2 or 3, if no return false, if so, go to the second loop, and check
    if its increasing or decreasing by comparing this element and the previous one and check
    if the precious one is smaller than this one. SLAY
     */
    for (i in 1 .. report.size-1) {
        val difference = Math.abs(report[i] - report[i - 1])
        if (difference !in 1..3) {
            return false
        }
    }
    var isIncreasing= true
    var isDecreasing = true

    for (i in 1 .. report.size-1) {
        if (report[i] <= report[i-1]) {
            isIncreasing=false
        }
        if (report[i]>=report[i-1]) {
            isDecreasing=false
        }
    }
    //czemu dziala jak ustawiam wpierw na true a jak na poczatku false to zle

    // jesli ktorekolwiek jest true to returnuje i mi idzie dalej to info do main i tam zlicza
    return isIncreasing||isDecreasing
}




