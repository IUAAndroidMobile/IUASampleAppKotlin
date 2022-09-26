package com.nicolasfanin.iuasampleappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Product
import com.nicolasfanin.iuasampleappkotlin.recyclerView.ProductListAdapter

class ProductListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val recyclerView = findViewById<RecyclerView>(R.id.product_list_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductListAdapter(initProducts())
    }

    private fun initProducts(): List<Product> =
        listOf(
            Product(
                title = "Auto 1",
                description = "Descripcion del auto 1",
                image = "http://www.asdasdasd.com",
                price = 100000.0
            ),
            Product(
                title = "Auto 2",
                description = "Descripcion del auto 2",
                image = "http://www.asdasdasd.com",
                price = 100000.0
            ),
            Product(
                title = "Auto 3",
                description = "Descripcion del auto 3",
                image = "http://www.asdasdasd.com",
                price = 100000.0
            ),
            Product(
                title = "Auto 4",
                description = "Descripcion del auto 4",
                image = "http://www.asdasdasd.com",
                price = 100000.0
            ),
            Product(
                title = "Auto 5",
                description = "Descripcion del auto 5",
                image = "http://www.asdasdasd.com",
                price = 100000.0
            )
        )
}