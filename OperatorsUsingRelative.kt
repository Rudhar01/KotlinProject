package com.example.kotlinpractice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OperatorsUsingRelative : AppCompatActivity() {
    lateinit var plus : Button
    lateinit var multiply : Button
    lateinit var minus : Button
    lateinit var divide :  Button
    lateinit var result : TextView
    var p = 4+4
    var m = 4-4
    var mi = 4*4
    var d = 4/4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operators_using_relative)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        plus=findViewById(R.id.edPlus)
        multiply=findViewById(R.id.edMultiply)
        minus=findViewById(R.id.edMinus)
        divide=findViewById(R.id.edDivide)
        result=findViewById(R.id.edResult)
        plus.setOnClickListener{
            result.text = "$p"
            }
        multiply.setOnClickListener{
            result.text = "$mi"
        }
        minus.setOnClickListener{
            result.text = "$m"
        }
        divide.setOnClickListener{
            result.text = "$d"
        }
        }
    }
