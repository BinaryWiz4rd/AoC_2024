package com.example.aoc_2024.day2

import java.io.File

fun main() {

    var safeCount = 0

        File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\day2\\day2.txt")
            .forEachLine { line ->
            val report = line.split(" ").map { it.toInt() }

            if (isItSafe(report) || problemDumpener(report)) {
                safeCount++
            }
        }

        println("amount of safe reports: $safeCount")
}

fun isItSafe(report: List<Int>): Boolean {
    for (i in 1 .. report.size-1) {
        val difference = Math.abs(report[i] - report[i - 1])
        if (difference !in 1..3) {
            return false
        }
    }
    var isIncreasing = true
    var isDecreasing = true

    for (i in 1 .. report.size-1) {
        if (report[i] <= report[i - 1]) {
            isIncreasing = false
        }
        if (report[i] >= report[i - 1]) {
            isDecreasing = false
        }
    }

    return isIncreasing || isDecreasing
}

fun problemDumpener(report: List<Int>): Boolean {
    // tu probuje wywalic jeden element i sprawdzam czy jest legitny
    //https://stackoverflow.com/questions/41782779/how-do-we-remove-elements-from-a-mutablelist-in-kotlin
    for (i in report.indices) {
        val newReport = report.toMutableList().apply { removeAt(i) }
        if (isItSafe(newReport)) {
            return true
        }
    }
    return false
}

