package com.example.kotlinproject.BottomNavigation

import android.content.Context

data class Item(
    var itemName : String? = null,
    var itemPrice : String? = null
){

    override fun toString(): String {
        return itemName.toString()
    }
}
