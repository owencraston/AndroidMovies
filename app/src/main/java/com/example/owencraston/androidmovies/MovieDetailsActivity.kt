package com.example.owencraston.androidmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_details.*
import kotlinx.android.synthetic.main.movie_row.view.*


class MovieDetailsActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val movie = intent.getParcelableExtra<Movie>("movie")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        // set navbar title
        supportActionBar?.title = movie.title
        // set textViews
        textView_movie_detail_title.text = movie.title
        textView_movie_detail_rating.text = movie.vote_average
        textView_movie_detail_release_date.text = movie.release_date
        textView_movie_detail_overview.text = movie.overview
    }

}