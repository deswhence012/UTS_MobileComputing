package com.caratutorial.aplikasiloginsederhana

import android.R
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : Activity() {
    var b1: Button? = null
    var b2: Button? = null
    var ed1: EditText? = null
    var ed2: EditText? = null
    var tx1: TextView? = null
    var counter = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 = findViewById<View>(R.id.btnLogin) as Button
        b2 = findViewById<View>(R.id.btnCancel) as Button
        ed1 = findViewById<View>(R.id.editUser) as EditText
        ed2 = findViewById<View>(R.id.editPass) as EditText
        tx1 = findViewById<View>(R.id.textView2) as TextView
        tx1!!.visibility = View.GONE
        b1!!.setOnClickListener {
            //set username dan password dengan "admin"
            if (ed1!!.text.toString() == "admin" && ed2!!.text.toString() == "admin") //kondisi jika login benar
                Toast.makeText(applicationContext, "Login Sukses", Toast.LENGTH_SHORT).show() else {

                //jika login gagal
                Toast.makeText(
                    applicationContext, "Username atau Password Anda Salah",
                    Toast.LENGTH_SHORT
                ).show()
                tx1!!.visibility = View.VISIBLE
                tx1!!.setBackgroundColor(Color.RED)
                counter--
                tx1!!.text = Integer.toString(counter)
                if (counter == 0) {
                    b1!!.isEnabled = false
                }
            }
        }
        b2!!.setOnClickListener { finish() }
    }
}