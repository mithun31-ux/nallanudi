package com.example.nallanudi.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nallanudi.R
import com.example.nallanudi.WordDetailActivity
import com.example.nallanudi.models.Word

class WordAdapter(
    private var wordList: List<Word>
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtEnglish: TextView =
            view.findViewById(R.id.txtEnglish)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_word, parent, false)

        return WordViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: WordViewHolder,
        position: Int
    ) {

        val currentWord = wordList[position]

        holder.txtEnglish.text = currentWord.english

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                WordDetailActivity::class.java
            )

            // PASS DATA

            intent.putExtra(
                "english",
                currentWord.english
            )

            intent.putExtra(
                "kannada",
                currentWord.kannada
            )

            intent.putExtra(
                "explanation",
                currentWord.explanation
            )

            intent.putExtra(
                "simpleMeaning",
                currentWord.simpleMeaning
            )

            intent.putExtra(
                "exampleEnglish",
                currentWord.exampleEnglish
            )

            intent.putExtra(
                "exampleKannada",
                currentWord.exampleKannada
            )

            intent.putExtra(
                "pronunciationTip",
                currentWord.pronunciationTip
            )

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    fun updateList(newList: List<Word>) {

        wordList = newList
        notifyDataSetChanged()
    }
}