package com.nicolasfanin.iuasampleappkotlin.recyclerView

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R

class ColorListAdapter(private val data: List<Color>, private val listener: RecyclerViewOnClickListener) : RecyclerView.Adapter<ColorListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorListViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item_view_color, parent, false)
        return ColorListViewHolder(row, listener)
    }

    override fun onBindViewHolder(holder: ColorListViewHolder, position: Int) {
        val color = data.get(position)

        holder.colorName.text = color.name
        holder.colorHexa.text = color.hex

        //Cambiamos el color de la View
        val gradient = holder.circleView.background as GradientDrawable
        val colorId = android.graphics.Color.parseColor(color.hex)
        gradient.setColor(colorId)
    }

    override fun getItemCount(): Int = data.size

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

interface RecyclerViewOnClickListener {
    fun onItemClick(position: Int)
}