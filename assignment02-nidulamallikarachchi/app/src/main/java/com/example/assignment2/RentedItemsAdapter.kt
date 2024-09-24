package com.example.assignment2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class RentedItemsAdapter (private val context: Context, private val rentedItems: List<RentedItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return rentedItems.size
    }

    override fun getItem(position: Int): Any {
        return rentedItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val rentedItem = rentedItems[position]

        viewHolder.rentedItemImageView.setImageResource(rentedItem.imageId)
        viewHolder.rentedItemNameTextView.text = rentedItem.instrumentName
        viewHolder.rentedItemQuantityTextView.text = "Quantity: ${rentedItem.quantity}"

        return view

    }

    private class ViewHolder(view: View) {
        val rentedItemImageView: ImageView = view.findViewById(R.id.rentedItemImageView)
        val rentedItemNameTextView: TextView = view.findViewById(R.id.rentedItemNameTextView)
        val rentedItemQuantityTextView: TextView = view.findViewById(R.id.rentedItemQuantityTextView)
    }
}