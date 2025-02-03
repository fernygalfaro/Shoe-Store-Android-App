package alfaro.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageActivity : AppCompatActivity() {

    private lateinit var shoeRecyclerView: RecyclerView
    private lateinit var shoeAdapter: ShoeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        shoeRecyclerView = findViewById(R.id.shoeRecyclerView)
        shoeRecyclerView.layoutManager = LinearLayoutManager(this)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_men -> {
                    shoeAdapter.updateShoes(getMenShoes())
                    true
                }
                R.id.nav_women -> {
                    shoeAdapter.updateShoes(getWomenShoes())
                    true
                }
                else -> false
            }
        }

        shoeAdapter = ShoeAdapter(getMenShoes()) { shoe ->
            val intent = Intent(this, ShoeDetailActivity::class.java)
            intent.putExtra("shoe", shoe)
            startActivity(intent)
        }
        shoeRecyclerView.adapter = shoeAdapter
    }

    private fun getMenShoes(): List<Shoe> {
        return listOf(
            Shoe("Adidas Sambas White", listOf("7", "9", "9.5", "10", "11", "11.5", "12"), R.drawable.adidas),
            Shoe("Florsheim Chalet Cap Toe Boot", listOf("11", "11.5", "12"), R.drawable.menboot ),
            Shoe("Madden Mens Aaline Oxford", listOf("8", "8.5", "10", "11"), R.drawable.oxford),
            Shoe("Brooks Glycerin Running Shoes", listOf("7.5", "9.5", "10", "11", "13"), R.drawable.menrunning),
            Shoe("Birkenstock Arizona Sandal", listOf("7","7.5","8", "8.5", "9", "9.5", "10", "10.5", "11"), R.drawable.mensandals)

        )
    }

    private fun getWomenShoes(): List<Shoe> {
        return listOf(
            Shoe("Mia Patton Bottie", listOf("6", "6.5", "7", "9"), R.drawable.blackbootie),
            Shoe("Eurosoft Mckaila Sandal", listOf("7", "7.5", "8.5", "9", "10"), R.drawable.bluesandal),
            Shoe("Jessica Simpson Miliny Pump", listOf("5.5", "7", "7.5", "8.5", "9", "10", "11"), R.drawable.pinkheel),
            Shoe("Brooks Ghost 15 Running Shoe", listOf("8", "8.5", "9", "9.5", "10", "10.5", "11.5", "12"), R.drawable.womensrunning),
            Shoe("Journee Collection Saar Pump", listOf("6", "6.5", "7"), R.drawable.blueflats)
        )
    }
}