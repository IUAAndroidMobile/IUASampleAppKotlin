package com.nicolasfanin.iuasampleappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.networking.ProductDTO
import com.nicolasfanin.iuasampleappkotlin.networking.ProductListDTO
import com.nicolasfanin.iuasampleappkotlin.networking.ProductRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkingActivity : AppCompatActivity() {

    lateinit var productService: ProductRetrofit
    lateinit var serviceResult: Call<ProductListDTO>
    lateinit var data: List<ProductDTO>

    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_networking)

        resultTextView = findViewById<TextView>(R.id.networking_info)

        productService = ProductRetrofit()
        getProductListFromServerOption2()
    }


    fun getProductListFromServerOption2() {
        serviceResult = productService.productRetrofitService.getProductList()
        serviceResult.enqueue(object : Callback<ProductListDTO> {
                override fun onResponse(
                    call: Call<ProductListDTO>,
                    response: Response<ProductListDTO>
                ) {
                    resultTextView.text = response.body().toString()
                    response.body()?.let {
                        data = it.listaProductos
                    }
                    resultTextView.text = data[1].toString()
                    //hideLoader
                }

                override fun onFailure(call: Call<ProductListDTO>, t: Throwable) {
                    resultTextView.text = t.message

                }
            })
    }


}