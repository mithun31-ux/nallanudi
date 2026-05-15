package com.example.nallanudi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val btnBack = findViewById<android.widget.ImageView>(R.id.btnBack)

        val optionLanguage = findViewById<LinearLayout>(R.id.optionLanguage)
        val optionTextSize = findViewById<LinearLayout>(R.id.optionTextSize)
        val optionTheme = findViewById<LinearLayout>(R.id.optionTheme)
        val optionFeedback = findViewById<LinearLayout>(R.id.optionFeedback)
        val optionShare = findViewById<LinearLayout>(R.id.optionShare)
        val optionRate = findViewById<LinearLayout>(R.id.optionRate)

        btnBack.setOnClickListener {
            finish()
        }

        optionLanguage.setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_LOCALE_SETTINGS))
        }

        optionTextSize.setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_DISPLAY_SETTINGS))
        }

        optionTheme.setOnClickListener {
            startActivity(Intent(android.provider.Settings.ACTION_DISPLAY_SETTINGS))
        }

        optionFeedback.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)

            intent.type = "message/rfc822"

            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@nallanudi.com"))

            intent.putExtra(Intent.EXTRA_SUBJECT, "Nalla-Nudi Feedback")

            startActivity(Intent.createChooser(intent, "Send Feedback"))
        }

        optionShare.setOnClickListener {

            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.type = "text/plain"

            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Download Nalla-Nudi App!"
            )

            startActivity(Intent.createChooser(shareIntent, "Share App"))
        }

        optionRate.setOnClickListener {

            val uri = Uri.parse("https://play.google.com/store")

            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }
    }
}