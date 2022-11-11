package com.nicolasfanin.iuasampleappkotlin.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.nicolasfanin.iuasampleappkotlin.MyApplication
import com.nicolasfanin.iuasampleappkotlin.database.model.ProductEntity
import com.nicolasfanin.iuasampleappkotlin.databinding.ActivitySplashBinding
import com.nicolasfanin.iuasampleappkotlin.fragments.MyFragmentsActivity
import com.nicolasfanin.iuasampleappkotlin.preferences.MySharedPreferences
import com.nicolasfanin.iuasampleappkotlin.utils.MY_INTENT_ACTIVITY_VALUE
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

class SplashActivity : AppCompatActivity() {

    private val REQUEST_CODE = 100

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.navigateToList.setOnClickListener {
            //Tu acción aca!
            val myIntent = Intent(this, MyIntentActivity::class.java)
            myIntent.putExtra(MY_INTENT_ACTIVITY_VALUE, "Nico")

            startActivityForResult(myIntent, REQUEST_CODE)
        }

        binding.navigateToRecyclerView.setOnClickListener {
            startActivity(Intent(this, ColorListActivity::class.java))
        }

        binding.navigateToFragments.setOnClickListener {
            startActivity(Intent(this, MyFragmentsActivity::class.java))
        }

        binding.navigateToScanQr.setOnClickListener {
            IntentIntegrator(this).initiateScan()
        }

        binding.navigateToCalbacks.setOnClickListener {
            startActivity(Intent(this, CallbacksActivity::class.java))
        }

        binding.navigateToProductList.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }

        binding.navigateToNavigationDrawer.setOnClickListener {
            startActivity(Intent(this, NavigationDrawerActivity::class.java))
        }

        binding.navigateToDatabaseInspect.setOnClickListener{
            startActivity((Intent(this, DatabaseInspectActivity::class.java)))
        }

        insertProducts()

    }

    private fun insertProducts() {
        runBlocking {
            launch {
                MyApplication.myAppDatabase.productDao().insertProduct(
                    ProductEntity(
                        title = "Producto 1 BD",
                        description = "Description 1 BD",
                        imageURL = "",
                        price = 50.0
                    )
                )
                MyApplication.myAppDatabase.productDao().insertProduct(
                    ProductEntity(
                        title = "Producto 2 BD",
                        description = "Description 2 BD",
                        imageURL = "",
                        price = 50.0
                    )
                )
                MyApplication.myAppDatabase.productDao().insertProduct(
                    ProductEntity(
                        title = "Producto 3 BD",
                        description = "Description 3 BD",
                        imageURL = "",
                        price = 50.0
                    )
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (MyApplication.preferences.getUserName()
                .isNotEmpty() || MyApplication.preferences.getUserName().isNotBlank()
        ) {
            binding.userNameEditText.setText(MyApplication.preferences.getUserName())
        }
    }

    override fun onPause() {
        super.onPause()
        MyApplication.preferences.setUserName(binding.userNameEditText.text.toString())
        binding.userNameEditText.setText("")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                data?.getStringExtra("RESULTADO")
                Toast.makeText(baseContext, data?.dataString, Toast.LENGTH_LONG).show()
            }
        }
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Sin resultado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El valor escaneado es: ${result.contents}", Toast.LENGTH_LONG)
                    .show()

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.naigateToMovieListButton).setOnClickListener{
            navigateToMovieList()
        }
    }*/

    private fun navigateToMovieList() {
        startActivity(Intent(this, ColorListActivity::class.java))
    }

    fun checkInternet(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    true
                }
                else -> false
            }
        }
        return false
    }


}
