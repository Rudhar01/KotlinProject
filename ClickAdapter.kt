package com.example.kotlinproject.RecyclerView

interface ClickAdapter {
    fun edit(position : Int)
    fun delete(position : Int)

    fun displayItem(position: Int)
}