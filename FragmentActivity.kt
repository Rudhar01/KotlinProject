package com.example.kotlinproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinproject.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentBinding
    lateinit var clickInterface: clickInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnRed.setOnClickListener {
            clickInterface.changeColor(1)
        }
        binding.btnBlack.setOnClickListener {
            clickInterface.changeColor(2)
        }
        binding.btnOffWhite.setOnClickListener {
            clickInterface.changeColor(3)
        }
        binding.btnblue.setOnClickListener {
            clickInterface.changeColor(4)
        }
    }
}