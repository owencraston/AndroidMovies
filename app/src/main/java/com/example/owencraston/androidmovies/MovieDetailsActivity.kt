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
        textView_movie_detail_rating.text = "Rating: ${movie.vote_average}"
        textView_movie_detail_release_date.text = "Release Date: ${movie.release_date}"
        textView_movie_details_adult.text = "Adult: ${movie.adult}"
        textView_movie_detail_overview.text = movie.overview

        // set image
        val movie_poster_url = "https://image.tmdb.org/t/p/w500/${movie.poster_path}"
        Picasso.get().load(movie_poster_url).into(imageView_movie_detail_poster)
    }

}