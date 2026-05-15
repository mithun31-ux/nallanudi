package com.example.nallanudi

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class WordDetailActivity : AppCompatActivity() {

    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_word_detail)

        // VIEWS

        val txtWord =
            findViewById<TextView>(R.id.txtWord)

        val txtKannada =
            findViewById<TextView>(R.id.txtKannada)

        val txtExplanation =
            findViewById<TextView>(R.id.txtExplanation)

        val txtSimple =
            findViewById<TextView>(R.id.txtSimple)

        val txtExample =
            findViewById<TextView>(R.id.txtExample)

        val btnSpeak =
            findViewById<ImageView>(R.id.btnSpeak)

        val btnBack =
            findViewById<ImageView>(R.id.btnBack)

        val btnBookmark =
            findViewById<ImageView>(R.id.btnBookmark)

        // DATA

        val english =
            intent.getStringExtra("english") ?: ""

        val kannada =
            intent.getStringExtra("kannada") ?: ""

        val explanation =
            intent.getStringExtra("explanation") ?: ""

        val simpleMeaning =
            intent.getStringExtra("simpleMeaning") ?: ""

        val exampleEnglish =
            intent.getStringExtra("exampleEnglish") ?: ""

        val exampleKannada =
            intent.getStringExtra("exampleKannada") ?: ""

        // SET TEXT

        txtWord.text = english

        txtKannada.text = kannada

        txtExplanation.text = explanation

        txtSimple.text = simpleMeaning

        txtExample.text =
            "$exampleEnglish\n\n$exampleKannada"

        // TEXT TO SPEECH

        // TEXT TO SPEECH

        tts = TextToSpeech(this) { status ->

            if (status == TextToSpeech.SUCCESS) {

                val result =
                    tts?.setLanguage(Locale.US)

                if (
                    result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED
                ) {

                    btnSpeak.isEnabled = false
                }
            }
        }

// SPEAK BUTTON

        btnSpeak.setOnClickListener {

            btnSpeak.isEnabled = false

            tts?.stop()

            tts?.speak(
                english,
                TextToSpeech.QUEUE_FLUSH,
                null,
                null
            )

            btnSpeak.postDelayed({

                btnSpeak.isEnabled = true

            }, 2000)
        }

        // BACK BUTTON

        btnBack.setOnClickListener {

            finish()
        }

        // BOOKMARK BUTTON

        btnBookmark.setOnClickListener {

            BookmarkManager.addBookmark(english)

            btnBookmark.setImageResource(
                android.R.drawable.btn_star_big_on
            )
        }
    }

    override fun onDestroy() {

        tts?.stop()

        tts?.shutdown()

        super.onDestroy()
    }
}