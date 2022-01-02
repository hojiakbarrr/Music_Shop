package com.example.music_shop

import android.widget.ImageView
import java.io.Serializable

class Order (
    var clientName : String = "",
    var orderKolich : Int = 0,
    var price : Int = 0,
    var imageId: Int = 0,
    var ItemName: String = ""
) : Serializable