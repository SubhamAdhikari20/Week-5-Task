package com.example.week_5_task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week_5_task.R
import com.example.week_5_task.databinding.ActivityDashboardBinding

class FeedAdapter(
    val context : Context,
    val imageList : ArrayList<Int>,
    val titleList : ArrayList<String>,
    val descList : ArrayList<String>

    ) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>(){
    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.imageView)
        val title : TextView = itemView.findViewById(R.id.titleText)
        val desc : TextView = itemView.findViewById(R.id.descText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        // Linking recycler view with sample pictures view
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.feed_layout, parent, false)
        return FeedViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        // Passing the data
        holder.title.text = titleList[position]
        holder.desc.text = descList[position]
        holder.image.setImageResource(imageList[position])
    }
}