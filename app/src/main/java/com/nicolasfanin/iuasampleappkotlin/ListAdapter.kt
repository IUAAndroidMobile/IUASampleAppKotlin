package com.nicolasfanin.iuasampleappkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val data: List<Color>, val listener: RecyclerViewOnClickListener) : RecyclerView.Adapter<ListAdapter.PalleteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PalleteViewHolder =
        PalleteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_color_view, parent, false), listener)

    override fun onBindViewHolder(holder: PalleteViewHolder, position: Int) {
        val color = data[position]
        holder.titleTextView.text = color.name
        holder.subtitleTextView.text = color.hex

        holder.circleView.setBackgroundColor(android.graphics.Color.parseColor(color.hex))
    }

    override fun getItemCount(): Int = data.size

    class PalleteViewHolder(itemView: View, listener: RecyclerViewOnClickListener) : RecyclerView.ViewHolder(itemView) {
        val circleView = itemView.findViewById<View>(R.id.circleView)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val subtitleTextView = itemView.findViewById<TextView>(R.id.subtitleTextView)

        init {
            itemView.setOnClickListener(View.OnClickListener {
                listener.onItemClickListener(adapterPosition)
            })
        }
    }

    interface RecyclerViewOnClickListener {
        fun onItemClickListener(position: Int)
    }

}
