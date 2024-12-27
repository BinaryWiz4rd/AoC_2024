package com.example.aoc_2024.day4

import java.io.File

fun main() {
    /*
    idea: https://www.youtube.com/watch?v=0ekhKsd_YYA
    Last year, i did this type of problem by using countless loops which was terrible.
    But i had no idea how to solve that problem in other way, so i watched this video, that
    has helped me to discover a different, and more elegant way.

    Idea is the following: Make it possible to read it always from left to right.
    So we use different functions maps have, i.e if we want to look for XMAS from right to left,
    we simply reverse the input matrix we have. And so on.
     */
    val input =
        File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day4\\day4_sample.txt")
            .readLines().map { it.trim() }

    fun partA (input:List<String>):Int{
        val leftToRight: List<String> = input
        val rightToLeft: List<String> = input.map {it.reversed()}
        val topToBottom: List<String> = input.pivot()
        val bottomToTop: List<String> = topToBottom.map {it.reversed()}

        val BottomLeftToTopRight: List<String> = input.tippedRight()
        val TopRightToBottomLeft: List<String> = BottomLeftToTopRight.map {it.reversed()}
        val TopLeftToBottomRight: List<String> = input.tippedLeft()
        val BottomRightToTopLeft: List<String> = TopLeftToBottomRight.map {it.reversed()}

        val all: List<String> = leftToRight + rightToLeft + topToBottom + bottomToTop +
                BottomLeftToTopRight+TopRightToBottomLeft+TopLeftToBottomRight+BottomRightToTopLeft

        return all.sumOf {Regex("XMAS").findAll(it).count() }
    }

    fun pivot (input:List<String>): List<String> {
        /*
        We go through all columns (y), and we append all of them in the inner loop,
        same about rows (x).
         */
        val characters: List<String> = this
        return buildList {this: MutableList<String>
        for (x: Int in characters[0].indices){
            add(buildString { this: StringBuilder
            for (y:Int in characters.indices){
                append(characters[y][x])
            }
            })
        }
        }

    }

    fun List<String>.tippedRight(): List<String> {

    }
}

