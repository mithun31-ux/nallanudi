package com.example.nallanudi

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val editSearch = findViewById<EditText>(R.id.editSearch)
        val cardSearch = findViewById<MaterialCardView>(R.id.cardSearch)
        val cardSaved = findViewById<MaterialCardView>(R.id.cardSaved)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        // SEARCH BAR

        editSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        // SEARCH CARD

        cardSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        // SAVED CARD

        cardSaved.setOnClickListener {
            startActivity(Intent(this, SavedWordsActivity::class.java))
        }

        // BOTTOM NAVIGATION

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {
                    true
                }

                R.id.nav_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }

                R.id.nav_saved -> {
                    startActivity(Intent(this, SavedWordsActivity::class.java))
                    true
                }

                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }
}