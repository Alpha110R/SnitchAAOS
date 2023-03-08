package com.example.snitchaaoskotlin.utils

class MyCharSequence(private val sequence: String) : CharSequence {
    override val length: Int
        get() = sequence.length

    override fun get(index: Int): Char {
        return sequence[index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return MyCharSequence(sequence.substring(startIndex, endIndex))
    }

    override fun toString(): String {
        return sequence
    }
}