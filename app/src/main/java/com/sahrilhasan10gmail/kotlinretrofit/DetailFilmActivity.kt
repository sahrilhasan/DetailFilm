package com.sahrilhasan10gmail.kotlinretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail_film.*

class DetailFilmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)
        Log.d("DetailFilmActivity",intent.getStringExtra("NAMAFILM"))

        judul.setText(intent.getStringExtra("NAMAFILM"))
    }
}
