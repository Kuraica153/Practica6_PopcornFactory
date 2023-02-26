package kuraica.christopher.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class ItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        //initialize the UI elements
        val headerImage: ImageView = findViewById(R.id.header_image)
        val title: TextView = findViewById(R.id.title)
        val sinopsis: TextView = findViewById(R.id.sinopsis)
        val noSeats: TextView = findViewById(R.id.seatsLeft)
        val buyButton: Button = findViewById(R.id.btnBuyTicket)
        //get the intent
        var extras = intent.extras
        //get the data from the intent
        var itemId = extras?.getInt("id")
        var itemTitle = extras?.getString("title")
        var itemSinopsis = extras?.getString("sinopsis")
        var itemHeader = extras?.getInt("header")
        var noSeatsAvailable = extras?.getInt("noSeats")
        //set the data to the UI elements
        title.text = itemTitle
        sinopsis.text = itemSinopsis
        headerImage.setImageResource(itemHeader!!)
        noSeats.text = "Seats available: $noSeatsAvailable"

        if (noSeatsAvailable == 0)
            buyButton.isEnabled = false
        else{
            buyButton.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)
                //pass the data to the next activity
                intent.putExtra("id", itemId)
                intent.putExtra("title", itemTitle)

                startActivity(intent)
            }
        }

    }
}