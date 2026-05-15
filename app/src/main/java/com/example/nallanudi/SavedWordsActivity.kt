package com.example.nallanudi

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SavedWordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_saved_words)

        val layoutContainer =
            findViewById<LinearLayout>(R.id.layoutContainer)

        val layoutEmpty =
            findViewById<LinearLayout>(R.id.layoutEmpty)

        if (
            BookmarkManager.bookmarkedWords.isEmpty()
        ) {

            layoutEmpty.visibility =
                View.VISIBLE

        } else {

            layoutEmpty.visibility =
                View.GONE

            for (word in BookmarkManager.bookmarkedWords) {

                val textView = TextView(this)

                textView.text = word

                textView.textSize = 22f

                textView.setPadding(
                    20,
                    20,
                    20,
                    20
                )

                layoutContainer.addView(textView)
            }
        }
    }
}