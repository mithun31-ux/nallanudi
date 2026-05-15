package com.example.nallanudi

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nallanudi.adapters.WordAdapter
import com.example.nallanudi.models.Word

class SearchActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WordAdapter
    private lateinit var etSearch: EditText
    private lateinit var btnSearch: ImageButton
    private lateinit var btnBack: ImageView

    private val wordList = listOf(

        Word(
            english = "Algorithm",
            kannada = "ಅಲ್ಗಾರಿದಮ್",
            explanation = "ಒಂದು ಸಮಸ್ಯೆಯನ್ನು ಪರಿಹರಿಸಲು ಬಳಸುವ ಕ್ರಮಬದ್ಧ ವಿಧಾನ.",
            simpleMeaning = "ಯಾವುದೇ ಕೆಲಸವನ್ನು ಮಾಡುವ ಹಂತಗಳ ಸರಣಿ.",
            exampleEnglish = "Sorting is an example of an algorithm.",
            exampleKannada = "ಸೋರ್ಟಿಂಗ್ ಒಂದು ಅಲ್ಗಾರಿದಮ್ ಉದಾಹರಣೆ.",
            pronunciationTip = "al-go-ri-thm"
        ),

        Word(
            english = "Gravity",
            kannada = "ಗುರುತ್ವಾಕರ್ಷಣೆ",
            explanation = "ವಸ್ತುಗಳನ್ನು ಕೆಳಕ್ಕೆ ಎಳೆಯುವ ಶಕ್ತಿ.",
            simpleMeaning = "ಭೂಮಿ ಎಲ್ಲವನ್ನೂ ತನ್ನ ಕಡೆಗೆ ಎಳೆಯುವ ಶಕ್ತಿ.",
            exampleEnglish = "Gravity pulls objects down.",
            exampleKannada = "ಗುರುತ್ವಾಕರ್ಷಣೆ ವಸ್ತುಗಳನ್ನು ಕೆಳಗೆ ಎಳೆಯುತ್ತದೆ.",
            pronunciationTip = "gra-vi-ty"
        ),

        Word(
            english = "Photosynthesis",
            kannada = "ಪ್ರಕಾಶ ಸಂಶ್ಲೇಷಣೆ",
            explanation = "ಸಸ್ಯಗಳು ಆಹಾರ ತಯಾರಿಸುವ ಪ್ರಕ್ರಿಯೆ.",
            simpleMeaning = "ಸಸ್ಯಗಳು ತಮ್ಮ ಆಹಾರವನ್ನು ತಯಾರಿಸುವ ವಿಧಾನ.",
            exampleEnglish = "Plants prepare food by photosynthesis.",
            exampleKannada = "ಸಸ್ಯಗಳು ಪ್ರಕಾಶ ಸಂಶ್ಲೇಷಣೆಯಿಂದ ಆಹಾರ ತಯಾರಿಸುತ್ತವೆ.",
            pronunciationTip = "fo-to-syn-the-sis"
        ),

        Word(
            english = "Compiler",
            kannada = "ಕಂಪೈಲರ್",
            explanation = "ಕೋಡ್ ಅನ್ನು ಯಂತ್ರ ಭಾಷೆಗೆ ಪರಿವರ್ತಿಸುವ ಸಾಧನ.",
            simpleMeaning = "ಪ್ರೋಗ್ರಾಂ ಅನ್ನು ಕಂಪ್ಯೂಟರ್ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವ ಭಾಷೆಗೆ ಬದಲಾಯಿಸುವುದು.",
            exampleEnglish = "Compiler converts code into machine language.",
            exampleKannada = "ಕಂಪೈಲರ್ ಕೋಡ್ ಅನ್ನು ಯಂತ್ರ ಭಾಷೆಗೆ ಬದಲಾಯಿಸುತ್ತದೆ.",
            pronunciationTip = "com-pile-er"
        ),

        Word(
            english = "Database",
            kannada = "ಡೇಟಾಬೇಸ್",
            explanation = "ಮಾಹಿತಿಯನ್ನು ಸಂಗ್ರಹಿಸುವ ವ್ಯವಸ್ಥೆ.",
            simpleMeaning = "ಡೇಟಾವನ್ನು ಉಳಿಸುವ ಸ್ಥಳ.",
            exampleEnglish = "Student details are stored in database.",
            exampleKannada = "ವಿದ್ಯಾರ್ಥಿಗಳ ಮಾಹಿತಿ ಡೇಟಾಬೇಸ್‌ನಲ್ಲಿ ಉಳಿಸಲಾಗಿದೆ.",
            pronunciationTip = "day-ta-base"
        ),

        Word(
            english = "Interface",
            kannada = "ಇಂಟರ್ಫೇಸ್",
            explanation = "ಎರಡು ವ್ಯವಸ್ಥೆಗಳ ಸಂಪರ್ಕ ಭಾಗ.",
            simpleMeaning = "ಬಳಕೆದಾರ ಮತ್ತು ವ್ಯವಸ್ಥೆಯ ನಡುವಿನ ಸಂಪರ್ಕ.",
            exampleEnglish = "Mobile screen is a user interface.",
            exampleKannada = "ಮೊಬೈಲ್ ಪರದೆ ಒಂದು ಯೂಸರ್ ಇಂಟರ್ಫೇಸ್.",
            pronunciationTip = "in-ter-face"
        ),

        Word(
            english = "Operating System",
            kannada = "ಆಪರೇಟಿಂಗ್ ಸಿಸ್ಟಮ್",
            explanation = "ಕಂಪ್ಯೂಟರ್ ಕಾರ್ಯಗಳನ್ನು ನಿರ್ವಹಿಸುವ ವ್ಯವಸ್ಥೆ.",
            simpleMeaning = "ಕಂಪ್ಯೂಟರ್ ಅನ್ನು ನಡೆಸುವ ಮುಖ್ಯ ಸಾಫ್ಟ್‌ವೇರ್.",
            exampleEnglish = "Android is an operating system.",
            exampleKannada = "ಆಂಡ್ರಾಯ್ಡ್ ಒಂದು ಆಪರೇಟಿಂಗ್ ಸಿಸ್ಟಮ್.",
            pronunciationTip = "op-er-a-ting sys-tem"
        ),

        Word(
            english = "Array",
            kannada = "ಅರೆ",
            explanation = "ಒಂದೇ ರೀತಿಯ ಮಾಹಿತಿಗಳ ಗುಂಪು.",
            simpleMeaning = "ಒಂದೇ ರೀತಿಯ ಡೇಟಾ ಸಂಗ್ರಹ.",
            exampleEnglish = "Array stores multiple values.",
            exampleKannada = "ಅರೆ ಅನೇಕ ಮೌಲ್ಯಗಳನ್ನು ಸಂಗ್ರಹಿಸುತ್ತದೆ.",
            pronunciationTip = "a-ray"
        ),

        Word(
            english = "Recursion",
            kannada = "ಪುನರಾವರ್ತಿ",
            explanation = "ಒಂದು function ತನ್ನನ್ನೇ ಕರೆದುಕೊಳ್ಳುವ ವಿಧಾನ.",
            simpleMeaning = "ಒಂದು ಕಾರ್ಯ ಮತ್ತೆ ತನ್ನನ್ನೇ ನಡೆಸುವುದು.",
            exampleEnglish = "Recursion is used in programming.",
            exampleKannada = "ಪ್ರೋಗ್ರಾಮಿಂಗ್‌ನಲ್ಲಿ ರಿಕರ್ಷನ್ ಬಳಸಲಾಗುತ್ತದೆ.",
            pronunciationTip = "re-cur-sion"
        ),

        Word(
            english = "Data Structure",
            kannada = "ಡೇಟಾ ಸ್ಟ್ರಕ್ಚರ್",
            explanation = "ಮಾಹಿತಿಯನ್ನು ವ್ಯವಸ್ಥಿತವಾಗಿ ಸಂಗ್ರಹಿಸುವ ವಿಧಾನ.",
            simpleMeaning = "ಡೇಟಾವನ್ನು ಸರಿಯಾಗಿ ವ್ಯವಸ್ಥೆಗೊಳಿಸುವ ವಿಧಾನ.",
            exampleEnglish = "Stack is a data structure.",
            exampleKannada = "ಸ್ಟಾಕ್ ಒಂದು ಡೇಟಾ ಸ್ಟ್ರಕ್ಚರ್.",
            pronunciationTip = "day-ta struc-ture"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerView = findViewById(R.id.recyclerView)
        etSearch = findViewById(R.id.etSearch)
        btnSearch = findViewById(R.id.btnSearch)
        btnBack = findViewById(R.id.btnBack)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        adapter = WordAdapter(emptyList())
        recyclerView.adapter = adapter

        // LIVE SEARCH

        etSearch.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                filterWords(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        // SEARCH BUTTON

        btnSearch.setOnClickListener {

            val query = etSearch.text.toString()

            val matchedWord = wordList.find {

                it.english.equals(
                    query,
                    ignoreCase = true
                )
            }

            if (matchedWord != null) {

                val intent = Intent(
                    this,
                    WordDetailActivity::class.java
                )

                intent.putExtra(
                    "english",
                    matchedWord.english
                )

                intent.putExtra(
                    "kannada",
                    matchedWord.kannada
                )

                intent.putExtra(
                    "explanation",
                    matchedWord.explanation
                )

                intent.putExtra(
                    "simpleMeaning",
                    matchedWord.simpleMeaning
                )

                intent.putExtra(
                    "exampleEnglish",
                    matchedWord.exampleEnglish
                )

                intent.putExtra(
                    "exampleKannada",
                    matchedWord.exampleKannada
                )

                intent.putExtra(
                    "pronunciationTip",
                    matchedWord.pronunciationTip
                )

                startActivity(intent)
            }
        }

        // BACK BUTTON

        btnBack.setOnClickListener {

            finish()
        }
    }

    private fun filterWords(query: String) {

        if (query.isEmpty()) {

            adapter.updateList(emptyList())
            return
        }

        val filteredList = wordList.filter {

            it.english.contains(
                query,
                ignoreCase = true
            )
        }

        val sortedList = filteredList.sortedBy {

            it.english
        }

        adapter.updateList(sortedList)
    }
}