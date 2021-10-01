package com.nicolasfanin.iuasampleappkotlin.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.databinding.ActivityMyFragmentsBinding

class MyFragmentsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMyFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_fragments_container) as NavHostFragment
        navHostFragment.navController.navInflater.inflate(R.navigation.navigation_my_fragments) **/

    }

}