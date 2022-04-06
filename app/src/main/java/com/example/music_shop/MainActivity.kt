package com.example.music_shop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.io.Serializable
import org.jetbrains.annotations.NotNull




class MainActivity : AppCompatActivity() , Serializable {
    private var spinner: Spinner? = null
    private lateinit var name11: EditText
    private var button_plus: Button? = null
    private var button_minus: Button? = null
    private var addOrder: Button? = null
    private var textorder: TextView? = null
    private var textsum: TextView? = null
    var count = 0
    private var Guitar: Int = 150
    private var Flute: Int = 123
    private var Komuz: Int = 976
    var itog: Int? = 0
    private var list = Remove.list;

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    fun getStaticField(): ArrayList<Order> {
        return this.list
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name11 = findViewById(R.id.userName)
        textorder = findViewById(R.id.textView4)
        textsum = findViewById(R.id.textView2)
        button_plus = findViewById(R.id.button2)
        button_minus = findViewById(R.id.button3)
        addOrder = findViewById(R.id.button)

        spinner = findViewById(R.id.spinner)
        val list = arrayListOf("Musical instrument's", "Guitar", "Flute", "Komuz")

        val adap = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list)
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner?.adapter = adap
        spinner?.setSelection(0)


        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long
            ) {
                changeImage(p2)

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


    }


    private fun changeImage(p2: Int) {
        val image: ImageView = findViewById(R.id.imageView2)


        if (p2 == 0) {
            count = 1
            image.setImageResource(R.drawable.brand)
            textorder?.hint
        }
        if (p2 == 1) {
            count = 1
            image.setImageResource(R.drawable.guitar)
            textorder?.text = Guitar.toString()
            textsum?.setText("1")
            change("Guitar", R.drawable.guitar, Guitar)
        }
        if (p2 == 2) {
            count = 1
            image.setImageResource(R.drawable.flute)
            textorder?.text = Flute.toString()
            textsum?.setText("1")
            change("Flute", R.drawable.flute, Flute)

        }
        if (p2 == 3) {
            count = 1
            image.setImageResource(R.drawable.komuz)
            textorder?.text = Komuz.toString()
            textsum?.setText("1")
            change("Komuz", R.drawable.komuz, Komuz)

        }
    }

    private fun change(nameofMusic: String, ImageId: Int, price: Int) {

        button_plus?.setOnClickListener {
            count++
            itog = count * price
            textorder?.text = itog.toString()
            textsum?.text = count.toString()

        }
        button_minus?.setOnClickListener {

            if (count > 0) {
                count--
                itog = count * price
                textorder?.text = itog.toString()
                textsum?.text = count.toString()

            }

        }
        addOrder?.setOnClickListener {
            val order = Order()
//            if (textorder?.text.toString() == "" || name11.text.toString() == "" || textsum?.text.toString() == ""){
//                Toast.makeText(this, "где то что то пусто", Toast.LENGTH_SHORT).show()
//
//            }else{
//                order.clientName = name11.text.toString()
//                order.price = textorder!!.text.toString().toInt()
//                order.orderKolich = textsum!!.text.toString().toInt()
//                order.ItemName = nameofMusic
//                addImages()
//                if (isAdded(order)){
//                    Toast.makeText(this, "Такой товар уже добавлен", Toast.LENGTH_SHORT).show()
//                }else{
//                    orderList.add(order)
//                    Toast.makeText(this, "order is add", Toast.LENGTH_SHORT).show()
//                }
//            }
            if (textorder?.text != "0" && name11.text.toString() != "" ){
                order.clientName = name11.text.toString()
                order.price = textorder!!.text.toString().toInt()
                order.orderKolich = textsum!!.text.toString().toInt()
                order.ItemName = nameofMusic
                if (nameofMusic == "Komuz"){
                    order.imageId = R.drawable.komuz
                }else if (nameofMusic == "Flute"){
                    order.imageId = R.drawable.flute
                }else{
                    order.imageId = R.drawable.guitar
                }
                addImages()
                if (isAdded(order)){
                    Toast.makeText(this, "Такой товар уже добавлен", Toast.LENGTH_SHORT).show()
                }else{
                    list.add(order)
                    Toast.makeText(this, "order is add", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "где то что то пусто", Toast.LENGTH_SHORT).show()

            }
        }

    }
    private fun addImages(){
//        for (o in list){
//            when(o.ItemName){
//                "Guitar" -> o.imageId = R.drawable.guitar
//                "Flute" -> o.imageId = R.drawable.flute
//                "Komuz" -> o.imageId = R.drawable.komuz
//            }
//        }

    }
    private fun isAdded(order: Order):Boolean{
        for (o in list){
            if (o.ItemName == (order.ItemName)){
                return true
            }
        }
        return false
    }
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.cart){
//            val intent = Intent(this@MainActivity, OrderActivity::class.java)
//            if (orderList.isNullOrEmpty()){
//                intent.putExtra("zakaz", orderList as Serializable)
//                startActivity(intent)
//            }
//        }
//        return super.onContextItemSelected(item)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cart -> {
                    val intent = Intent(this@MainActivity, OrderActivity::class.java)
                if (list.isNotEmpty()){
                    intent.putExtra("zakaz", list as Serializable)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Корзина пустая", Toast.LENGTH_SHORT).show()

                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}