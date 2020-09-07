package com.nicolasfanin.iuasampleappkotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MyMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(initColors())
    }

    private fun initColors(): List<Color> {
        val colors = mutableListOf<Color>()

        colors.add(Color(getString(R.string.blue), ContextCompat.getColor(this, R.color.blue).toString()))
        colors.add(Color(getString(R.string.indigo), ContextCompat.getColor(this, R.color.indigo).toString()))
        colors.add(Color(getString(R.string.red), ContextCompat.getColor(this, R.color.red).toString()))
        colors.add(Color(getString(R.string.green), ContextCompat.getColor(this, R.color.green).toString()))
        colors.add(Color(getString(R.string.orange), ContextCompat.getColor(this, R.color.orange).toString()))
        colors.add(Color(getString(R.string.grey), ContextCompat.getColor(this, R.color.grey).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))
        colors.add(Color(getString(R.string.teal), ContextCompat.getColor(this, R.color.teal).toString()))

        return colors
    }
}