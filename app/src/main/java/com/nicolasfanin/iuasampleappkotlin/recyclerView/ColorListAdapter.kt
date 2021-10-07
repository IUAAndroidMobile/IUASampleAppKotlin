package com.nicolasfanin.iuasampleappkotlin.recyclerView

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R

class ColorListAdapter(private val data: List<Color>, private val listener: RecyclerViewOnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val COLOR_ITEM = 1
    val COLOR_TITLE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == COLOR_ITEM) {
            val row =
                LayoutInflater.from(parent.context).inflate(R.layout.item_view_color, parent, false)
            return ColorListViewHolder(row, listener)
        } else {
            val row = LayoutInflater.from(parent.context).inflate(R.layout.item_view_color_title, parent, false)
            return TitleViewHolder(row)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == COLOR_ITEM) {
            val color = data.get(position)

            (holder as ColorListViewHolder).colorName.text = color.name
            (holder as ColorListViewHolder).colorHexa.text = color.hex

            //Cambiamos el color de la View
            val gradient = holder.circleView.background as GradientDrawable
            val colorId = android.graphics.Color.parseColor(color.hex)
            gradient.setColor(colorId)
        } else {
            (holder as TitleViewHolder).titleTextView.text = data.get(position).name
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = data[position].type

}

class ColorListViewHolder(itemView: View, listener: RecyclerViewOnClickListener) : RecyclerView.ViewHolder(itemView) {
    var circleView: View = itemView.findViewById(R.id.circle_view)
    var colorName: TextView = itemView.findViewById(R.id.text_view_color_name)
    var colorHexa: TextView = itemView.findViewById(R.id.text_view_color_hexa)

    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}

class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleTextView: TextView = itemView.findViewById(R.id.text_view_color_title)
}

interface RecyclerViewOnClickListener {
    fun onItemClick(position: Int)
}