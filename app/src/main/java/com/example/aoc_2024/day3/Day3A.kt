package com.example.aoc_2024.day3

import java.io.File

fun main() {
    /*
    Here we were supposed to search through entire file, and look for stuff with ideal format:
    mul(numberX,numberY)
    Then we should multiply Y by X.
     */
    val input = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day3\\day3.txt")
    val readInput = input.readText()
    // strona: https://regex101.com/
    // regex zeby mi szukal tylko mul(X,Y):
    // d+ czyli szukaj digits, bedzie ich minimum 1
    // \\) szukaj )
    val regex = Regex("mul\\((\\d+),(\\d+)\\)")

    var totalSum = 0

    val matches = regex.findAll(readInput)

    //idea: https://stackoverflow.com/questions/6375873/regular-expression-groups-in-c-sharp
    for (match in matches) {
        val x = match.groupValues[1].toInt()  // potrzymaj mi pierwsza liczbe, czyli X z mul(X,Y)
        val y = match.groupValues[2].toInt()
        totalSum += x * y
    }
    println("total sum: $totalSum")
}
