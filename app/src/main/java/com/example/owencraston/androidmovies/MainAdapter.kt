package com.example.owencraston.androidmovies

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*


class MainAdapter(): RecyclerView.Adapter<CustomViewHolder>()  {

    private var movieCollection : List<Movie> = emptyList()

    override fun getItemCount(): Int {
        return movieCollection.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellRow)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movie = movieCollection.get(position)
        val movie_backdrop_url = "https://image.tmdb.org/t/p/original/${movie.backdrop_path}"
        holder.view.textView_movie_title.text = movie.title
        Picasso.get().load(movie_backdrop_url).into(holder?.view?.imageView_movie_backdrop)
    }

    fun setData(data : List<Movie>) {
        movieCollection = data
        notifyDataSetChanged()
    }


}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, MovieDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}