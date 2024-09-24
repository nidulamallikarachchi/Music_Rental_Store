package com.example.assignment2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class InstrumentAdapter (private val context: Context, private var instruments: List<Instrument>) : BaseAdapter(){
    //Get Array Count of Instrument Objects Implemented in MainActivity.kt
    override fun getCount(): Int {
        return instruments.size
    }

    //Return Item
    override fun getItem(position: Int): Any {
        return instruments[position]
    }

    //Return Item ID
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //Implement Item View
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //View Recycling Check
        var gridItemView = convertView

        if(gridItemView == null){
            gridItemView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
        }

        val currentInstrument = instruments [position]

        val imageView = gridItemView!!.findViewById<ImageView>(R.id.imageView)
        val textView = gridItemView.findViewById<TextView>(R.id.textView)

        //Set Image Resource for Grid Item in Home Page
        imageView.setImageResource(currentInstrument.imageId)

        //Set Text View for Grid Item in Home Page
        textView.text = currentInstrument.instrumentName

        //Set Rating Bar Level for Item in Home Page
        val ratingBar = gridItemView.findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = currentInstrument.instrumentRating.toFloat()

        return gridItemView
    }

    public fun updateInstruments(newInstruments: List<Instrument>){
        instruments = newInstruments
        notifyDataSetChanged()
    }
}