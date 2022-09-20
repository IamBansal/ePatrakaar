package com.example.e_patrakaar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_patrakaar.R
import com.example.e_patrakaar.models.News

class NewsAdapter(private var context: Context, private var list : ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val headline : TextView = itemView.findViewById(R.id.tvHeadline)
        val location : TextView = itemView.findViewById(R.id.tvNewsLocation)
        val time : TextView = itemView.findViewById(R.id.tvNewsTime)
        val image : ImageView = itemView.findViewById(R.id.ivNewsHeader)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_news, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = list[position]
        holder.headline.text = news.Headline
        holder.location.text = news.Location
        holder.time.text = news.Time
        holder.image.setImageResource(news.Image!!)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}