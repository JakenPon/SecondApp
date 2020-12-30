package com.example.secondapp.data.repository
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.secondapp.R
import com.example.secondapp.data.repository.response.CountriesItem
import kotlinx.android.synthetic.main.item.view.*





@GlideModule
class AppGlideModule : AppGlideModule()

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var items = ArrayList<CountriesItem>()


    fun setListData(data: List<CountriesItem>) {
        var newValue = ArrayList<CountriesItem>()
        for(e in data){
            newValue.add(e)
        }
        this.items = newValue
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
        val currentItem = items[position]

    }

    override fun getItemCount(): Int{
        return items.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageDrapeau =  itemView.imageDrapeau
        private val textView1: TextView = itemView.text_view_1
        private val textView2: TextView = itemView.text_view_2

        fun bind(data: CountriesItem){
            textView1.text = data.name
            textView2.text = data.capital

        val url = data.flag

           GlideApp.with(itemView.context)
                .load(url)
                .into(imageDrapeau)





        }
    }
}