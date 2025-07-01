package com.example.kotlinproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class Dashboard : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var name1 : TextView
    lateinit var email1 : TextView
    lateinit var edit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        name=findViewById(R.id.Name)
        name1=findViewById(R.id.Name1)
        email1 = findViewById(R.id.email1)
        edit=findViewById(R.id.Edit)
        var intent = intent
        var str1 = intent.extras?.getString("Msg")
        var str2 = intent.extras?.getString("Email")
        name1.text= str1.toString()
        email1.text = str2.toString()
    }
}