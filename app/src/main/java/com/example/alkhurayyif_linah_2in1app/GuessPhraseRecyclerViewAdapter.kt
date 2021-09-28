package com.example.alkhurayyif_linah_2in1app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.phrase_recycler_view.view.*

class GuessPhraseRecyclerViewAdapter(val messages: ArrayList<String>):
    RecyclerView.Adapter<GuessPhraseRecyclerViewAdapter.GuessthephraseViewHolder>() {
    class GuessthephraseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuessthephraseViewHolder {
        return GuessthephraseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.phrase_recycler_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: GuessthephraseViewHolder, position: Int) {
        val message = messages[position]
        holder.itemView.apply {
            guessthephraseMessage.text= message
        }
    }


    override fun getItemCount()= messages.size
}