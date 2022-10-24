package com.nicolasfanin.iuasampleappkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Product

//Listado de Productos
class MyFirstFragment: Fragment() {

    private lateinit var myFirstFragmentButton : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_first, container, false)
        myFirstFragmentButton = view.findViewById(R.id.my_first_fragment_button)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myFirstFragmentButton.setOnClickListener {
            val direction = MyFirstFragmentDirections.actionMyFirstFragmentToMySecondFragment()
            direction.productItem = Product(title = "Producto 1", description = "Descripcion del producto 1", imageURL = "http://...", 500.0)
            direction.arg2 = "123"
            Navigation.findNavController(view).navigate(direction)
        }
    }

}