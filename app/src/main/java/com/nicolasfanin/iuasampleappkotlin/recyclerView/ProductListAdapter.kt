package com.nicolasfanin.iuasampleappkotlin.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R

class ProductListAdapter(val data: List<Product>) :RecyclerView.Adapter<ProductViewHolder>() {

    //Devuelve el view holder inflado.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_view, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = data[position]
        holder.productTitle.text = product.title
        holder.productDescription.text = product.description

        //PENDIENTE: Agregar imagen!
    }

    override fun getItemCount(): Int = data.size
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var productTitle: TextView = itemView.findViewById(R.id.product_title)
    var productDescription: TextView = itemView.findViewById(R.id.product_description)
    var productImage: TextView = itemView.findViewById(R.id.product_image)
}