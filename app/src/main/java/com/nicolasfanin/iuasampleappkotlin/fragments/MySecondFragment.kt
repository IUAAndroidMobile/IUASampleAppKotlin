package com.nicolasfanin.iuasampleappkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Product

//Detalle del producto
class MySecondFragment: Fragment() {

    private lateinit var mySecondButton: Button
    private lateinit var titleProduct: TextView

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

        titleProduct = view.findViewById(R.id.fragment_title)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { arg ->
            val idProducto = arg.getString("id_producto")
            Toast.makeText(context, idProducto, Toast.LENGTH_LONG).show()

            val producto = arg.getParcelable<Product>("product_item")

            titleProduct.text = producto?.title
        }
    }
}