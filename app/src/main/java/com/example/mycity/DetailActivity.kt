package com.example.mycity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_TAHUN = "extra_tahun"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvTahun: TextView = findViewById(R.id.tv_item_tahun)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val ivPhoto: ImageView = findViewById(R.id.img_item_photo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val tahun = intent.getStringExtra(EXTRA_TAHUN)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, -1)

        tvName.text = name
        tvTahun.text = tahun
        tvDescription.text = description
        ivPhoto.setImageResource(photo)
    }
}