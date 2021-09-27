package com.nicolasfanin.iuasampleappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Color
import com.nicolasfanin.iuasampleappkotlin.recyclerView.ColorListAdapter
import com.nicolasfanin.iuasampleappkotlin.recyclerView.RecyclerViewOnClickListener

class ColorListActivity : AppCompatActivity(), RecyclerViewOnClickListener {

    private val colorsList = mutableListOf<Color>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)

       initColors()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_color_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ColorListAdapter(colorsList, this)
    }


    private fun initColors()  {
        colorsList.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colorsList.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colorsList.add(Color(getString(R.string.green), getString(R.string.greenHex)))
        colorsList.add(Color(getString(R.string.orange), getString(R.string.orangeHex)))
        colorsList.add(Color(getString(R.string.blue), getString(R.string.blueHex)))
        colorsList.add(Color(getString(R.string.yellow), getString(R.string.yellowHex)))
        colorsList.add(Color(getString(R.string.grey), getString(R.string.greyHex)))
        colorsList.add(Color(getString(R.string.teal), getString(R.string.tealHex)))
        colorsList.add(Color(getString(R.string.deeppurple), getString(R.string.deeppurpleHex)))
        colorsList.add(Color(getString(R.string.cyan), getString(R.string.cyanHex)))
        colorsList.add(Color(getString(R.string.brown), getString(R.string.brownHex)))
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(baseContext, "Su color seleccionado es: ${colorsList[position].name}", Toast.LENGTH_SHORT).show()
    }
}