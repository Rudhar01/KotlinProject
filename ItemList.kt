package com.example.kotlinproject.RecyclerView

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemList(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name : String? = null,
    var contact : String? = null,
    var age : String? = null
) {
}