package com.example.inhes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SearchFaskes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_faskes)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("Search Faskes")
    }
}