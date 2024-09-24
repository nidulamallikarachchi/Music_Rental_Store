package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    companion object {
        val instruments = listOf(
            Instrument(R.drawable.acoustic_guitar, "Acoustic Guitar", 10, 10,5,"String"),
            Instrument(R.drawable.bass_guitar, "Bass Guitar", 10, 20,4,"String"),
            Instrument(R.drawable.classical_guitar, "Classical Guitar", 10, 10,3,"String"),
            Instrument(R.drawable.electric_guitar, "Electric Guitar", 10, 20,5,"String"),
            Instrument(R.drawable.drumkit, "Drum Kit", 10, 60,3,"Percussion"),
            Instrument(R.drawable.piano, "Piano", 10, 50,4,"Keyboard"),
            Instrument(R.drawable.organ, "Keyboard", 10, 20,2, "Keyboard"),
            Instrument(R.drawable.violin, "Violin", 10, 15,3, "String"),
            Instrument(R.drawable.ukelele, "Ukele", 10, 5,3,"String"),
            Instrument(R.drawable.saxaphone, "Saxophone", 10, 25,4,"Wind"),
            Instrument(R.drawable.trumpet, "Trumpet", 10, 25,5,"Wind"),
            Instrument(R.drawable.french_horn, "French Horn", 10, 35,5,"Wind")
        )

        var userCredit = 100

        val rentedItems = mutableListOf<RentedItem>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val gridView = findViewById<GridView>(R.id.gridView)

        val adapter = InstrumentAdapter(this, instruments)
        gridView.adapter = adapter

        val categories = instruments.map { it.instrumentCategory }.distinct()
        val chipGroup = findViewById<ChipGroup>(R.id.chipGroup)

        for (category in categories) {
            val chip = Chip(this).apply {
                text = category
                isCheckable = true
            }
            chipGroup.addView(chip)
        }

        chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId)
            if (chip != null){
                filterInstruments(chip.text.toString(),adapter)
            }
            else{
                adapter.updateInstruments(instruments)
            }
        }

        gridView.onItemClickListener = AdapterView.OnItemClickListener{_,_,position,_ ->
            val selectedInstrument = instruments[position]

            val intent = Intent(this, InstrumentDetailActivity::class.java)

            intent.putExtra("INSTRUMENT_IMAGE_ID", selectedInstrument.imageId)
            intent.putExtra("INSTRUMENT_NAME", selectedInstrument.instrumentName)
            intent.putExtra("INSTRUMENT_STOCK", selectedInstrument.stock)
            intent.putExtra("INSTRUMENT_CREDIT", selectedInstrument.instrumentCredit)
            intent.putExtra("INSTRUMENT_INDEX", position)
            intent.putExtra("INSTRUMENT_RATING", selectedInstrument.instrumentRating)

            startActivity(intent)
        }
    }

    private fun filterInstruments(category: String, adapter: InstrumentAdapter){
        val filteredList = instruments.filter { it.instrumentCategory == category }
        adapter.updateInstruments(filteredList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Inflate the menu_main.xml
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_items_bought -> {
                // When "Items Bought" menu item is clicked, navigate to BoughtItemsActivity
                val intent = Intent(this, RentedItemsActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.my_credit -> {
                val intent = Intent(this, MyCreditActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}