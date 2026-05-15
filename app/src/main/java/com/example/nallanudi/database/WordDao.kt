package com.example.nallanudi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: WordEntity)

    @Query("SELECT * FROM words WHERE bookmarked = 1")
    suspend fun getSavedWords(): List<WordEntity>

    @Query("SELECT * FROM words WHERE english LIKE '%' || :query || '%'")
    suspend fun searchWords(query: String): List<WordEntity>
}