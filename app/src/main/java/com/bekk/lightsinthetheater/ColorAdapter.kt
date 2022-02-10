package com.bekk.lightsinthetheater

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(
    val colorList: ArrayList<String>
) : RecyclerView.Adapter<ColorAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numbering = itemView.findViewById<TextView>(R.id.tvPosition)
        val color = itemView.findViewById<TextView>(R.id.tvColor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            numbering.text = "${position+1}."
            color.text = colorList[position]
            when (colorList[position]){
                "Red" -> itemView.setBackgroundResource(R.drawable.red_bg)
                "Green" -> itemView.setBackgroundResource(R.drawable.green_bg)
                "Blue" -> itemView.setBackgroundResource(R.drawable.blue_bg)
                "White" -> {
                    itemView.setBackgroundResource(R.drawable.white_bg)
                    numbering.setTextColor(Color.parseColor("#000000"))
                    color.setTextColor(Color.parseColor("#000000"))
                }
                "on" -> {
                    itemView.setBackgroundResource(R.drawable.on_bg)
                    numbering.setTextColor(Color.parseColor("#000000"))
                    color.setTextColor(Color.parseColor("#000000"))
                }
                "off" -> itemView.setBackgroundResource(R.drawable.off_bg)
            }
        }
    }

    override fun getItemCount(): Int {
        return colorList.size
    }
}