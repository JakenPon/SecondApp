package com.example.secondapp.data.repository

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R
import com.example.secondapp.data.repository.response.Characters
import com.example.secondapp.data.repository.response.Result
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private val itemList: List<Result> ) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,
            parent, false)
         return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.imageView.setImageResource(currentItem.image.toInt())
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.location.toString()
    }

    override fun getItemCount() = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.imageView
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}