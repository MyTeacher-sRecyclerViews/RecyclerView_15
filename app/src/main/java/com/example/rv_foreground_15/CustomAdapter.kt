package com.example.rv_foreground_15

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(context: Context, private val users: ArrayList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view_foreground: RelativeLayout = itemView.findViewById(R.id.view_foreground)
    }
}