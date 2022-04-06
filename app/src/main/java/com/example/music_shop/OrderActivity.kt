package com.example.music_shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.annotation.IntegerRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable



class OrderActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var orderAdapter: OrderAdapter? = null
    var list: ArrayList<Order> = ArrayList()
    var listplus: ArrayList<String> = ArrayList()
    var button_send: Button? = null
    var image: String? = null
    var nameofInsrument: String? = null
    var client: String? = null
    var sum: String? = null
    var cena: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        list = intent.getSerializableExtra("zakaz") as ArrayList<Order>

        for (o in list) {
            image += " [" +o.imageId.toString() + "] "
            nameofInsrument += " [" +o.ItemName + "] "
            client += " [" +o.clientName +"] "
            sum += " [" +o.orderKolich.toString()+"] "
            cena += " [" +o.price.toString()+"] "

        }


        recyclerView = findViewById(R.id.recycle)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        orderAdapter = OrderAdapter(list)

        recyclerView?.adapter = orderAdapter

        button_send = findViewById(R.id.button4)

        findViewById<ImageView>(R.id.imageView3).setOnClickListener{
            Remove.list.clear()
        }



        button_send?.setOnClickListener {

            val email = Intent(Intent.ACTION_SEND)
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf("youremail@yahoo.com"))
            email.putExtra(Intent.EXTRA_SUBJECT, "new order")
            email.putExtra(Intent.EXTRA_TEXT, "Название товара: " + nameofInsrument + "\n" +
                        "Количество товара : " + sum + "\n" +
                        "Цена товара в долларах : " + cena +  "\n" +
                        "id товара : " + image + "\n" +
                        "имя клиента : " + client)
            email.type = "message/rfc822"
            startActivity(Intent.createChooser(email, "Choose an Email client :"))
//            val gmail = Intent(Intent.ACTION_VIEW)
//            gmail.setPackage("com.google.android.gm")
//            gmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("dzumabaev.hoziakbar@gmail.com"))
//            gmail.setPackage("com.google.android.gm")
//            gmail.putExtra(Intent.EXTRA_SUBJECT, "new order")
//            gmail.type = "message/rfc822"
//
//            gmail.putExtra(
//                Intent.EXTRA_TEXT, "Название товара " + nameofInsrument + "\n" +
//                        "Количество товара " + sum + "\n" +
//                        "Цена товара " + cena + "\n" +
//                        "id товара " + image + "\n" +
//                        "имя клиента " + client
//            )

//            startActivity(email)
        }


    }


}