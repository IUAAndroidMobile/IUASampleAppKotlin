package com.nicolasfanin.iuasampleappkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Color
import com.nicolasfanin.iuasampleappkotlin.recyclerView.ColorListAdapter

class ColorListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_color_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ColorListAdapter(initColors())
    }


    private fun initColors() : List<Color> {
        val colors = mutableListOf<Color>()

        colors.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colors.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colors.add(Color(getString(R.string.green), getString(R.string.greenHex)))
        colors.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colors.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colors.add(Color(getString(R.string.green), getString(R.string.greenHex)))
        colors.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colors.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colors.add(Color(getString(R.string.green), getString(R.string.greenHex)))
        colors.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colors.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colors.add(Color(getString(R.string.green), getString(R.string.greenHex)))

        return colors
    }
}