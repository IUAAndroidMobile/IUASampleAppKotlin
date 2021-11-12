package com.nicolasfanin.iuasampleappkotlin.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.nicolasfanin.iuasampleappkotlin.callbacks.ActionListenerCallback
import com.nicolasfanin.iuasampleappkotlin.callbacks.GetPostWorker
import com.nicolasfanin.iuasampleappkotlin.databinding.ActivityCallbacksBinding
import com.nicolasfanin.iuasampleappkotlin.networking.dataClasses.MuseumItem

class CallbacksActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCallbacksBinding

    private val worker: GetPostWorker = GetPostWorker(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallbacksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.progressBar.visibility = View.VISIBLE

        //Recuperar un Id.

        val qrId = "123456"

        callService(qrId)
    }

    private fun callService(qrId: String) {
        worker.setQRId(qrId)
        worker.doWork(object: ActionListenerCallback {
            override fun onActionSuccess(successMessage: MuseumItem) {
                Log.i("SUCCESS", successMessage.toString())
                binding.progressBar.visibility = View.GONE

                binding.titleItem.text = successMessage.item_title
                binding.titleItem.isVisible = true

                binding.titleDescription.text = successMessage.item_main_content
                binding.titleDescription.isVisible = true
            }

            override fun onActionFailure(throwableError: Throwable) {
                Log.i("FAILURE", throwableError.message)
            }
        })
    }
}