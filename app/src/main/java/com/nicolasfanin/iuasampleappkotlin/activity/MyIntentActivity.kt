package com.nicolasfanin.iuasampleappkotlin.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nicolasfanin.iuasampleappkotlin.databinding.ActivityMyIntentBinding
import com.nicolasfanin.iuasampleappkotlin.utils.MY_INTENT_ACTIVITY_VALUE
import com.nicolasfanin.iuasampleappkotlin.utils.RESULTADO

class MyIntentActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMyIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(baseContext, intent?.getStringExtra(MY_INTENT_ACTIVITY_VALUE), Toast.LENGTH_LONG).show()

        binding.activityResultButton.setOnClickListener {
            val intent = Intent()
            val resultado = "http://www..,.."
            intent.setData(Uri.parse(resultado))
            intent.putExtra(RESULTADO, "BIEN")
            setResult(RESULT_OK)
            finish()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(RESULT_CANCELED)
    }


}