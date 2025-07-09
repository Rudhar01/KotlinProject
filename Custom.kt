package com.example.kotlinproject.ViewList

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinproject.R

class CustomAdapter(var arrayList: ArrayList<MyData>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any? {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.base_adapter,parent,false)
        var name = view.findViewById<TextView>(R.id.tvName)
        var contact = view.findViewById<TextView>(R.id.tvContact)
        name.text = arrayList[position].name
        contact.text = arrayList[position].contact
        return view
    }
}