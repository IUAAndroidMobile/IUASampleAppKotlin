package com.nicolasfanin.iuasampleappkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Product
import com.nicolasfanin.iuasampleappkotlin.recyclerView.ProductListAdapter
import com.nicolasfanin.iuasampleappkotlin.recyclerView.ProductListOnClickListener

class ProductListActivity : AppCompatActivity(), ProductListOnClickListener {

    private val productList = createProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val recyclerView = findViewById<RecyclerView>(R.id.product_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductListAdapter(data = productList, listener = this)
    }

    private fun createProducts() = mutableListOf<Product>(
        Product(title = "Producto 1", description = "Descripcion del producto 1", imageURL = "https://www.pruebaderuta.com/wp-content/uploads/2015/05/superautos.jpg", 500.0),
        Product(title = "Producto 2", description = "Descripcion del producto 2", imageURL = "https://fotos.perfil.com//2019/10/07/900/0/cuales-son-los-autos-mas-potentes-del-mundo-788465.jpg", 500.0),
        Product(title = "Producto 3", description = "Descripcion del producto 3", imageURL = "https://www.pruebaderuta.com/wp-content/uploads/2015/05/superautos.jpg", 500.0),
        Product(title = "Producto 4", description = "Descripcion del producto 4", imageURL = "http://...", 500.0),
        Product(title = "Producto 5", description = "Descripcion del producto 5", imageURL = "http://...", 500.0),
        Product(title = "Producto 6", description = "Descripcion del producto 6", imageURL = "http://...", 500.0),
        Product(title = "Producto 1", description = "Descripcion del producto 1", imageURL = "http://...", 500.0),
        Product(title = "Producto 2", description = "Descripcion del producto 2", imageURL = "http://...", 500.0),
        Product(title = "Producto 3", description = "Descripcion del producto 3", imageURL = "http://...", 500.0),
        Product(title = "Producto 4", description = "Descripcion del producto 4", imageURL = "http://...", 500.0),
        Product(title = "Producto 5", description = "Descripcion del producto 5", imageURL = "http://...", 500.0),
        Product(title = "Producto 6", description = "Descripcion del producto 6", imageURL = "http://...", 500.0),
        Product(title = "Producto 1", description = "Descripcion del producto 1", imageURL = "http://...", 500.0),
        Product(title = "Producto 2", description = "Descripcion del producto 2", imageURL = "http://...", 500.0),
        Product(title = "Producto 3", description = "Descripcion del producto 3", imageURL = "http://...", 500.0),
        Product(title = "Producto 4", description = "Descripcion del producto 4", imageURL = "http://...", 500.0),
        Product(title = "Producto 5", description = "Descripcion del producto 5", imageURL = "http://...", 500.0),
        Product(title = "Producto 6", description = "Descripcion del producto 6", imageURL = "http://...", 500.0))

    override fun onItemClick(position: Int) {

        Toast.makeText(baseContext, "Su Producto seleccionado es: ${productList[position].title}", Toast.LENGTH_SHORT).show()

        val myIntent = Intent(this, MyIntentActivity::class.java)
        myIntent.putExtra("product",productList[position])
        startActivity(myIntent)

    }


}