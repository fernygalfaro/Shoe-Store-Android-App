package alfaro.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShoeAdapter(
    private var shoes: List<Shoe>,
    private val clickListener: (Shoe) -> Unit
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shoe_item, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.bind(shoes[position], clickListener)
    }

    override fun getItemCount() = shoes.size

    fun updateShoes(newShoes: List<Shoe>) {
        shoes = newShoes
        notifyDataSetChanged()
    }

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val shoeImage: ImageView = itemView.findViewById(R.id.shoeImage)
        private val shoeName: TextView = itemView.findViewById(R.id.shoeName)

        fun bind(shoe: Shoe, clickListener: (Shoe) -> Unit) {
            shoeImage.setImageResource(shoe.image)
            shoeName.text = shoe.name
            itemView.setOnClickListener { clickListener(shoe) }
        }
    }
}
