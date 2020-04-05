package nicestring

import java.util.Arrays.asList

fun String.isNice(): Boolean {
    fun containsDoubleLetters(): Boolean {
        for ((index, ch) in this.withIndex()) {
            if (index + 1 == this.length) return false
            if (ch == this[index + 1]) return true
        }
        return false
    }

    fun containsSubstrings(): Boolean {
        val substrings = asList("bu", "ba", "be")
        substrings.forEach { substring -> if (contains(substring)) return true }
        return false;
    }

    fun containsThreeVowels() : Boolean {
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
        return filter { it -> vowels.contains(it)}.count() >= 3
    }


    return asList(containsDoubleLetters(), !containsSubstrings(), containsThreeVowels())
            .filter { it }
            .count() >= 2

}