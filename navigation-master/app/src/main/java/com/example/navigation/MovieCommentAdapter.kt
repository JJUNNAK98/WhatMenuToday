package com.example.navigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_comment_item.view.*

class MovieCommentAdapter : RecyclerView.Adapter<MovieCommentAdapter.ViewHolder>() {
    var items = ArrayList<MovieComment>()

    lateinit var listener: OnMovieCommentClickListener

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_comment_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                listener?.onItemClick(this, itemView, adapterPosition)
            }
        }

        fun setItem(item: MovieComment) {
            itemView.idTextView.text = item.author
            itemView.dateTextView.text = item.date
            itemView.contentsTextView.text = item.contents.toString()
            itemView.recommendCountTextView.text = item.recommendCount.toString()
        }

    }

}