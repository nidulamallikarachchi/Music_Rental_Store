package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class InstrumentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instrument_detail)

        val instrumentImageView = findViewById<ImageView>(R.id.instrumentImageView)
        val instrumentNameTextView = findViewById<TextView>(R.id.instrumentNameTextView)
        val instrumentStockTextView = findViewById<TextView>(R.id.instrumentStockTextView)
        val instrumentCreditTextView = findViewById<TextView>(R.id.instrumentCreditTextView)
        val rentButton = findViewById<Button>(R.id.rentButton)
        var ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        val instrumentImageId = intent.getIntExtra("INSTRUMENT_IMAGE_ID", 0)
        val instrumentName = intent.getStringExtra("INSTRUMENT_NAME")
        var instrumentStock = intent.getIntExtra("INSTRUMENT_STOCK", 0)
        val instrumentIndex = intent.getIntExtra("INSTRUMENT_INDEX", -1)
        val instrumentCredit = intent.getIntExtra("INSTRUMENT_CREDIT", 0)
        val instrumentRating = intent.getIntExtra("INSTRUMENT_RATING",0)

        //Name
        instrumentNameTextView.text = instrumentName

        //Image
        instrumentImageView.setImageResource(instrumentImageId)

        //Stock
        instrumentStockTextView.text = "In Stock: $instrumentStock"

        //Credit
        instrumentCreditTextView.text = "$instrumentCredit/Credit Per Month"

        //Rating Bar
        ratingBar.rating = instrumentRating.toFloat()

        //Rent Button
        rentButton.setOnClickListener{
            if(instrumentStock > 0){
                if(MainActivity.userCredit >= instrumentCredit){
                    showConfirmationDialog(instrumentName!!, instrumentStock, instrumentImageId, instrumentCredit, instrumentIndex, instrumentStockTextView)
                }else{
                    showAlertDialog("Insufficient Credit", "You Don't have enough credit to rent this Item")
                }
            }else{
                instrumentStockTextView.text = "Out of Stock"
            }
        }
    }

    private fun showConfirmationDialog(instrumentName: String, instrumentStock: Int, instrumentImageId: Int, instrumentCredit: Int ,instrumentIndex: Int, instrumentStockTextView: TextView){

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Confirm Purchase")
        dialogBuilder.setMessage("Are you sure You want to Rent 1 $instrumentName")

        dialogBuilder.setPositiveButton("Yes"){dialog, which ->
            var updatedStock = instrumentStock -1
            instrumentStockTextView.text = "Stock: $updatedStock"

            MainActivity.instruments[instrumentIndex].stock = updatedStock

            MainActivity.userCredit -= instrumentCredit

            val rentedItem = MainActivity.rentedItems.find { it.instrumentName == instrumentName }

            if(rentedItem != null){
                rentedItem.quantity += 1
            }else{
                MainActivity.rentedItems.add(RentedItem(instrumentImageId,instrumentName!!, 1))
            }


            Toast.makeText(this, "Your item is ready for Pickup!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
        dialogBuilder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(this, "Cancellation in Progress!", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
        dialogBuilder.create().show()
    }

    private fun showAlertDialog(title: String, message: String){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle(title)
        dialogBuilder.setMessage(message)
        dialogBuilder.setPositiveButton("OK") { dialog, which -> dialog.dismiss()}
        dialogBuilder.create().show()
    }
}