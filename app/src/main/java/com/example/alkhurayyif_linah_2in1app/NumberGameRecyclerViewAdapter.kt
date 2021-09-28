package com.example.alkhurayyif_linah_2in1app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.number_recycler_view.view.*

class NumberGameRecyclerViewAdapter(private val numbers:ArrayList<String>): RecyclerView.Adapter<NumberGameRecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.number_recycler_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val number = numbers[position]
        holder.itemView.apply{
            TaskRecyclerView.text = number.toString()
        }
    }

    override fun getItemCount() = numbers.size

}