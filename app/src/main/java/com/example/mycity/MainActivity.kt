package com.example.mycity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCity: RecyclerView
    private val list = ArrayList<City>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCity = findViewById(R.id.rv_city)
        rvCity.setHasFixedSize(true)
        list.addAll(getListCity())
        showRecyclerList()
    }

    private fun getListCity(): ArrayList<City> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataTahun = resources.getStringArray(R.array.data_tahun)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listCity = ArrayList<City>()
        for (i in dataName.indices) {
            val city = City(dataName[i], dataTahun[i], dataDescription[i], dataPhoto.getResourceId
                (i, -1))
            listCity.add(city)
        }
        return listCity
    }

    private fun showRecyclerList() {
        rvCity.layoutManager = LinearLayoutManager(this)
        val cityAdapter = CityAdapter(list)
        rvCity.adapter = cityAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}