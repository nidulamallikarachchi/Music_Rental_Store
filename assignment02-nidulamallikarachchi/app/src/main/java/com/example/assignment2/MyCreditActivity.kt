package com.example.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MyCreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_credit)

        val currentCreditTextView = findViewById<TextView>(R.id.currentCreditTextView)
        val addCreditButton = findViewById<Button>(R.id.addCreditButton)

        currentCreditTextView.text = "Current Credit: ${MainActivity.userCredit}"

        addCreditButton.setOnClickListener{
            showConfirmationDialog(currentCreditTextView)
        }
    }
    private fun showConfirmationDialog(currentCreditTextView: TextView){
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Confirm Credit Purchase")
        dialogBuilder.setMessage("Are you sure you want to purchase 20 more credits")
        dialogBuilder.setPositiveButton("Yes"){ dialog, which ->
            MainActivity.userCredit += 20
            currentCreditTextView.text = "Existing Credit: ${MainActivity.userCredit}"
        }
        dialogBuilder.setNegativeButton("No"){ dialog, which ->
            dialog.dismiss()
        }
        dialogBuilder.create().show()
    }
}