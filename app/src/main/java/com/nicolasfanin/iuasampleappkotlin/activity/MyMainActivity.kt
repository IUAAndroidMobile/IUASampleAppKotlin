package com.nicolasfanin.iuasampleappkotlin.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicolasfanin.iuasampleappkotlin.recyclerView.Color
import com.nicolasfanin.iuasampleappkotlin.ListAdapter
import com.nicolasfanin.iuasampleappkotlin.R
import com.nicolasfanin.iuasampleappkotlin.viewmodel.MyViewModel


class MyMainActivity : AppCompatActivity(),
    ListAdapter.RecyclerViewOnClickListener {

    val colors = mutableListOf<Color>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel : MyViewModel by viewModels()
        viewModel.getColors().observe(this, Observer<List<Color>>{ list ->

        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =
            ListAdapter(initColors(), this)
    }

    private fun initColors(): List<Color> {
        colors.add(Color(getString(R.string.blue), getString(R.string.blueHex)))
        colors.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colors.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colors.add(Color(getString(R.string.green), getString(R.string.greenHex)))
        colors.add(Color(getString(R.string.orange), getString(R.string.orangeHex)))
        colors.add(Color(getString(R.string.grey), getString(R.string.greyHex)))
        colors.add(Color(getString(R.string.teal), getString(R.string.tealHex)))
        colors.add(Color(getString(R.string.brown), getString(R.string.brownHex)))
        colors.add(Color(getString(R.string.blue), getString(R.string.blueHex)))
        colors.add(Color(getString(R.string.indigo), getString(R.string.indigoHex)))
        colors.add(Color(getString(R.string.red), getString(R.string.redHex)))
        colors.add(Color(getString(R.string.green), getString(R.string.greenHex)))
        colors.add(Color(getString(R.string.orange), getString(R.string.orangeHex)))
        colors.add(Color(getString(R.string.grey), getString(R.string.greyHex)))
        colors.add(Color(getString(R.string.teal), getString(R.string.tealHex)))
        colors.add(Color(getString(R.string.brown), getString(R.string.brownHex)))

        return colors
    }

    override fun onItemClickListener(position: Int) {
        Toast.makeText(this, "Su Color es ${colors[position].name}", Toast.LENGTH_SHORT).show()
    }
}