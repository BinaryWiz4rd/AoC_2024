package com.example.aoc_2024.day4

import java.io.File
/*
CODE AND EXPLANATION STARTS IN MAIN, pivotB, and tipped are here, bc they have to be accessed globally
 */
fun List<String>.pivot(): List<String> {
    /*
    We go through all columns (y), and we append all of them in the inner loop,
    same about rows (x). We basicaly make columns rows, and rows columns.
     */
    return buildList {
        for (x in this@pivot[0].indices) {
            add(buildString {
                for (y in this@pivot.indices) {
                    append(this@pivot[y][x])
                }
            })
        }
    }
}
fun List<String>.tippedRight(): List<String> {
    /*
    przesuwamy o 45 stopni (w prawo)
    we drop because otherwise we would read it twice
     */
    val width: Int = this.first().length
    val height: Int = this.size

    return buildList {
        for (y in this@tippedRight.indices) {
            add(buildString {
                var cx = 0
                var cy: Int = y

                do {
                    append(this@tippedRight[cy][cx])
                    cx += 1
                    cy -= 1
                } while (cx < width && cy >= 0)
            })
        }

        for (x in 1 until width){ //start from 1 to drop the first column
            add(buildString {
                var cx: Int = x
                var cy: Int = height - 1

                do {
                    append(this@tippedRight[cy][cx])
                    cx += 1
                    cy -= 1
                } while (cx < width && cy >= 0)
            })
        }
    }
}

fun List<String>.tippedLeft(): List<String> {
    val width: Int = this.first().length
    val height: Int = this.size

    return buildList {
        for (y in this@tippedLeft.indices) {
            add(buildString {
                var cx = 0
                var cy: Int = y

                do {
                    append(this@tippedLeft[cy][cx])
                    cx += 1
                    cy += 1
                } while (cx < width && cy < height)
            })
        }

        for (x in 1 until width) {
            add(buildString {
                var cx: Int = x
                var cy: Int = 0

                do {
                    append(this@tippedLeft[cy][cx])
                    cx += 1
                    cy += 1
                } while (cx < width && cy < height)
            })
        }
    }
}
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
        File("C:\\Users\\aniaa\\Repositories\\AoC_2024\\app\\src\\main\\java\\com\\example\\aoc_2024\\day4\\day4.txt")
            .readLines().map { it.trim() }

    fun partA(input: List<String>): Int {
        val leftToRight: List<String> = input
        val rightToLeft: List<String> = input.map { it.reversed() }
        val topToBottom: List<String> = input.pivot()
        val bottomToTop: List<String> = topToBottom.map { it.reversed() }

        val BottomLeftToTopRight: List<String> = input.tippedRight()
        val TopRightToBottomLeft: List<String> = BottomLeftToTopRight.map { it.reversed() }
        val TopLeftToBottomRight: List<String> = input.tippedLeft()
        val BottomRightToTopLeft: List<String> = TopLeftToBottomRight.map { it.reversed() }

        val all: List<String> = leftToRight + rightToLeft + topToBottom + bottomToTop +
                BottomLeftToTopRight + TopRightToBottomLeft + TopLeftToBottomRight + BottomRightToTopLeft

        return all.sumOf { Regex("XMAS").findAll(it).count() }
    }

    val result = partA(input)
    println("xmas counter: $result")
}

