package com.nicolasfanin.iuasampleappkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nicolasfanin.iuasampleappkotlin.R

class MySecondFragment: Fragment() {

    private lateinit var mySecondButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_second, container, false)
        mySecondButton = view.findViewById(R.id.my_second_fragment_button)
        mySecondButton.setOnClickListener {
            val direction = MySecondFragmentDirections.actionMySecondFragmentToMyThirdFragment()
            Navigation.findNavController(view).navigate(direction)
        }

        return view
    }
}