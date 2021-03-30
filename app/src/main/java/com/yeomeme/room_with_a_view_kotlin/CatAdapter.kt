package com.yeomeme.room_with_a_view_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**

 * Created by yeomeme@gmail.com on 2021-03-30
 *
 */
class CatAdapter (val context: Context, val cats : List<Cat>) :
    RecyclerView.Adapter<CatAdapter.Holder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
          val view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent,false)
           return  Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(cats[position])
    }

    override fun getItemCount(): Int {
       return cats.size
    }

    inner class Holder(itemView : View?) : RecyclerView.ViewHolder(itemView!!) {

        val nameTv = itemView?.findViewById<TextView>(R.id.itemName)
        val lifeTv = itemView?.findViewById<TextView>(R.id.itemLifeSpan)
        val originTv = itemView?.findViewById<TextView>(R.id.itemOrigin)

        fun bind(cat : Cat) {
          nameTv?.text = cat.catName
          lifeTv?.text = cat.lifeSpan.toString()
          originTv?.text = cat.origin
        }
    }

}