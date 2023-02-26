package kuraica.christopher.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        // Initialize the UI elements
        val title: TextView = findViewById(R.id.movieTitle)
        val confirmButton: Button = findViewById(R.id.confirmButton)
        val RadioGroupOne: RadioGroup = findViewById(R.id.rowOne)
        val RadioGroupTwo: RadioGroup = findViewById(R.id.rowTwo)
        val RadioGroupThree: RadioGroup = findViewById(R.id.rowThree)
        val RadioGroupFour: RadioGroup = findViewById(R.id.rowFour)
        //get the intent
        val extras = intent.extras
        //get the data from the intent
        var movieId = extras?.getInt("id")
        var movieTitle = extras?.getString("title")
        //set the data to the UI elements
        title.text = movieTitle

        //set event listeners
        confirmButton.setOnClickListener {
            // Navigate to the menu activity
            val intent = Intent(this, SeatSelection::class.java)
            startActivity(intent)
        }

        RadioGroupOne.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId != -1){
                //clear the other radio groups
                RadioGroupTwo.clearCheck()
                RadioGroupThree.clearCheck()
                RadioGroupFour.clearCheck()
                //check the current radio group
                RadioGroupOne.check(checkedId)
            }
        }
        RadioGroupTwo.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId != -1){
                //clear the other radio groups
                RadioGroupOne.clearCheck()
                RadioGroupThree.clearCheck()
                RadioGroupFour.clearCheck()
                //check the current radio group
                RadioGroupTwo.check(checkedId)
            }
        }
        RadioGroupThree.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId != -1){
                //clear the other radio groups
                RadioGroupOne.clearCheck()
                RadioGroupTwo.clearCheck()
                RadioGroupFour.clearCheck()
                //check the current radio group
                RadioGroupThree.check(checkedId)
            }
        }
        RadioGroupFour.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId != -1){
                //clear the other radio groups
                RadioGroupOne.clearCheck()
                RadioGroupTwo.clearCheck()
                RadioGroupThree.clearCheck()
                //check the current radio group
                RadioGroupFour.check(checkedId)
            }
        }

    }
}