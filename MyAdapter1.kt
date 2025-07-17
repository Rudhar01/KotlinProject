package com.example.kotlinproject.BottomNavigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R


class MyAdapter1(var context: Context , var list : ArrayList<OrderModel> ) : RecyclerView.Adapter<MyAdapter1.ViewHolder>(){
    class ViewHolder ( var view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.menu_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var name = holder.view.findViewById<TextView>(R.id.menuName)
        var price = holder.view.findViewById<TextView>(R.id.menuPrice)
        name.text = list[position].itemName
        price.text = list[position].itemPrice.toString()


    }

    override fun getItemCount(): Int {
        return list.size
    }


}