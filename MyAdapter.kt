package com.example.kotlinproject.BottomNavigation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R


class MyAdapter(var context: Context , var list : ArrayList<Item> , var myInterface : MyInterface) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder ( var view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.view_recycle,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        var name = holder.view.findViewById<TextView>(R.id.tvName)
        var price = holder.view.findViewById<TextView>(R.id.tvPrice)
        var update = holder.view.findViewById<Button>(R.id.icUpdate)
        var delete = holder.view.findViewById<TextView>(R.id.icDelete)
        name.text = list[position].itemName
        price.text = list[position].itemPrice

        update.setOnClickListener {
            myInterface.edit(position)
        }
        delete.setOnClickListener {
            myInterface.delete(position)
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }


}