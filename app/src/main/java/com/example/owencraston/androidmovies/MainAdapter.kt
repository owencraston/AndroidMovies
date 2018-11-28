package com.example.owencraston.androidmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_row.view.*

class MainAdapter(val moveCollection: Result): RecyclerView.Adapter<CustomViewHolder>()  {

    override fun getItemCount(): Int {
        return moveCollection.movies.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellRow)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movie = moveCollection.movies.get(position)
        holder.view.textView_movie_title.text = movie.title
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {}