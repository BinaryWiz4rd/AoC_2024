package com.example.aoc_2024.day1

import java.io.BufferedReader
import java.io.File

class Day1A {
    //https://stackoverflow.com/questions/55182578/how-to-read-plain-text-file-in-kotlin
    fun read_file(args: Array<String>) {
        val bufferedReader: BufferedReader = File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day1\\day1.txt").bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        println(inputString)
    }
}
    fun main(args: Array<String>){
        val day1A = Day1A()
        day1A.read_file(args)
    }
