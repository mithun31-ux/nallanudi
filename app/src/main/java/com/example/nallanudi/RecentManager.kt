package com.example.nallanudi

import com.example.nallanudi.models.Word

object RecentManager {

    val recentWords =
        mutableListOf<Word>()

    fun addRecent(word: Word) {

        recentWords.remove(word)

        recentWords.add(0, word)

        if (recentWords.size > 10) {

            recentWords.removeAt(10)
        }
    }
}