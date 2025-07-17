package com.example.kotlinproject.BottomNavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var binding : ActivityBottomNavigationBinding
    var array = ArrayList<Item>()
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController = findNavController(R.id.NavHostFragment)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1-> {
                    navController.navigate(R.id.testFragment1)
                }
                R.id.item2->{
                    navController.navigate(R.id.testFragment2)
                }
            }
            return@setOnItemSelectedListener true
        }

    }
//    fun totalPrice() : String{
//        var sum = 0
//        for(i in 0..(array.size-1)){
//            sum = sum + (array[i].itemPrice)!!.toInt()
//        }
//        return sum.toString()
//    }
}