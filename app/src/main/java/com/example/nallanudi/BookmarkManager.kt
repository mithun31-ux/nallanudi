package com.example.nallanudi

object BookmarkManager {

    val bookmarkedWords =
        ArrayList<String>()

    fun addBookmark(word: String) {

        if (!bookmarkedWords.contains(word)) {

            bookmarkedWords.add(word)
        }
    }
}