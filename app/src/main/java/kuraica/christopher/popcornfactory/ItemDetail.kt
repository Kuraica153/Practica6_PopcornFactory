package kuraica.christopher.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        //initialize the UI elements
        val headerImage: ImageView = findViewById(R.id.header_image)
        val title: TextView = findViewById(R.id.title)
        val sinopsis: TextView = findViewById(R.id.sinopsis)
        //get the intent
        var extras = intent.extras
        //get the data from the intent
        var itemTitle = extras?.getString("title")
        var itemSinopsis = extras?.getString("sinopsis")
        var itemHeader = extras?.getInt("header")
        //set the data to the UI elements
        title.text = itemTitle
        sinopsis.text = itemSinopsis
        headerImage.setImageResource(itemHeader!!)
    }
}