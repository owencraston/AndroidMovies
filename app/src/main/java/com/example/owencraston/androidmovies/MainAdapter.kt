package com.example.owencraston.androidmovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.movie_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>()  {

    val movieTitles = listOf("first", "second", "third", "fourth")
    override fun getItemCount(): Int {
        return movieTitles.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellRow)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videoTitle = movieTitles.get(position)
        holder.view.textView_movie_title.text = videoTitle
    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {}