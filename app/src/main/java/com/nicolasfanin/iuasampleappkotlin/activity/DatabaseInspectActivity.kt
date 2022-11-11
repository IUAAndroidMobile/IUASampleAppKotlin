package com.nicolasfanin.iuasampleappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nicolasfanin.iuasampleappkotlin.MyApplication
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.database.model.ProductEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * https://kotlinlang.org/docs/coroutines-basics.html
 */
class DatabaseInspectActivity : AppCompatActivity() {

    lateinit var productDetail2 : TextView

    val productListLiveData = MutableLiveData<List<ProductEntity>>()
    val productByIdLiveData = MutableLiveData<ProductEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_inspect)
        productDetail2 = findViewById(R.id.database_info_text_view)

        // Region de Observers
        productListLiveData.observe(this, Observer { productList ->
            findViewById<TextView>(R.id.database_information).text = productList.toString()
        })

        productByIdLiveData.observe(this) { fillViewWithProductEntity(it) }
        //Fin Region de Observers

        getProductListForDatabase()
        getProductById(1)

    }

    private fun getProductListForDatabase() {
        runBlocking {
            launch(Dispatchers.IO) {
                productListLiveData.postValue(MyApplication.myAppDatabase.productDao().getAllProducts())
            }
        }
    }

    private fun getProductById(id: Int) {
        runBlocking {
            launch(Dispatchers.IO) {
                productByIdLiveData.postValue(
                    MyApplication.myAppDatabase.productDao().getProductById(id)
                )
            }
        }
    }

    private fun fillViewWithProductEntity(product: ProductEntity) {
        productDetail2.text = product.toString()
    }

}