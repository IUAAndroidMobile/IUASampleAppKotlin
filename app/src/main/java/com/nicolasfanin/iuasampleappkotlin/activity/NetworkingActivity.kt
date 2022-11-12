package com.nicolasfanin.iuasampleappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.networking.ProductRetrofit

class NetworkingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_networking)

        val productService = ProductRetrofit().productService

        findViewById<TextView>(R.id.networking_info).text = productService.getProductList().toString()
    }

}