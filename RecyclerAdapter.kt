package com.example.kotlinproject.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.RecyclerView.RoomDB.UserDao
import com.example.kotlinproject.clickInterface


class RecyclerAdapter(var List : ArrayList<ItemList> , var context : Context , var clickAdapter: ClickAdapter) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder( var view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view_recycle,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        var name= holder.view.findViewById<TextView>(R.id.tvName)
        var contact= holder.view.findViewById<TextView>(R.id.tvContact)
        var age= holder.view.findViewById<TextView>(R.id.tvAge)
        var update = holder.view.findViewById<Button>(R.id.icUpdate)
        var delete = holder.view.findViewById<Button>(R.id.icDelete)
        name.text = List[position].name
        contact.text = List[position].contact
        age.text = List[position].age


        update.setOnClickListener {
             clickAdapter.edit(position)
        }
        delete.setOnClickListener {
            clickAdapter.delete(position)
        }
        holder.view.setOnClickListener {
            clickAdapter.displayItem(position)
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }
}
