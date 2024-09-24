package com.example.assignment2

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RentedItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rented_items)

        val rentedItemsListView = findViewById<ListView>(R.id.rentedItemsListView)

        val rentedItems = MainActivity.rentedItems

        val adapter = RentedItemsAdapter(this, rentedItems)
        rentedItemsListView.adapter = adapter

    }
}