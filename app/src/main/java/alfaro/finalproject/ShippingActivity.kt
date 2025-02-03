package alfaro.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ShippingActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        database = FirebaseDatabase.getInstance().reference

        val shoe = intent.getSerializableExtra("shoe") as Shoe
        val shoeSize = intent.getStringExtra("size") ?: ""

        val confirmButton: Button = findViewById(R.id.confirmButton)
        confirmButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.nameEditText).text.toString()
            val address = findViewById<EditText>(R.id.addressEditText).text.toString()
            val city = findViewById<EditText>(R.id.cityEditText).text.toString()
            val postalCode = findViewById<EditText>(R.id.postalCodeEditText).text.toString()

            val order = Order(
                shoeName = shoe.name,
                shoeSize = shoeSize,
                customerName = name,
                address = address,
                city = city,
                postalCode = postalCode
            )
            database.child("orders").push().setValue(order)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    } else {
                    }
                }
        }
    }
}
