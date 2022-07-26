package com.example.listapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listapplication.R
import com.example.listapplication.model.Model
import java.util.*

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    var list: List<Model> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model = list[position]

        // sets the text to the textview from our itemHolder class

        holder.textName.text = model.name.capitalizeFirstChar()
        holder.textDetails.text = model.detail
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textName: TextView = itemView.findViewById(R.id.txt_name)
        val textDetails: TextView = itemView.findViewById(R.id.txt_details)
    }

    fun String.capitalizeFirstChar(): String = if (!isNullOrBlank()) replaceFirst (substring(0,1), substring(0,1).uppercase(
        Locale.ROOT)) else this
}