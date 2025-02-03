package alfaro.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShoeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoe_detail)

        val shoe = intent.getSerializableExtra("shoe") as Shoe
        val shoeImageView: ImageView = findViewById(R.id.shoeImageView)
        val shoeNameTextView: TextView = findViewById(R.id.shoeNameTextView)

        shoeImageView.setImageResource(shoe.image)
        shoeNameTextView.text = shoe.name

        val sizeSpinner: Spinner = findViewById(R.id.sizeSpinner)
        val sizesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shoe.sizes)
        sizesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sizeSpinner.adapter = sizesAdapter

        val orderButton: Button = findViewById(R.id.orderButton)
        orderButton.setOnClickListener {
            val selectedSize = sizeSpinner.selectedItem.toString()
            val intent = Intent(this, ShippingActivity::class.java).apply {
                putExtra("shoe", shoe)
                putExtra("size", selectedSize)
            }
            startActivity(intent)
        }
    }
}
