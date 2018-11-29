package com.example.owencraston.androidmovies

data class Result(val results: List<Movie>)

data class Movie(
    val vote_average: String,
    val vote_count: String,
    val id: Int,
    val video: Boolean,
    val media_type: String,
    val title: String,
    val popularity: Float,
    val poster_path: String,
    val genre_ids: List<Int>,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String
)