package com.nicolasfanin.iuasampleappkotlin.activity

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nicolasfanin.iuasampleappkotlin.callbacks.ActionListenerCallback
import com.nicolasfanin.iuasampleappkotlin.callbacks.GetPostWorker
import com.nicolasfanin.iuasampleappkotlin.databinding.ActivityCallbacksBinding

class CallbacksActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCallbacksBinding

    private val worker: GetPostWorker = GetPostWorker(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallbacksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.progressBar.visibility = View.VISIBLE

        worker.setActionListener(object: ActionListenerCallback {
            override fun onActionSuccess(successMessage: String) {
                Log.i("SUCCESS", successMessage)
                binding.progressBar.visibility = View.GONE
            }

            override fun onActionFailure(throwableError: Throwable) {
                Log.i("FAILURE", throwableError.message)
            }
        })

    }
}