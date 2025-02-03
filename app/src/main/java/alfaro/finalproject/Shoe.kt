package alfaro.finalproject

import java.io.Serializable

data class Shoe(
    val name: String,
    val sizes: List<String>,
    val image: Int
) : Serializable