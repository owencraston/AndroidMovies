package com.example.owencraston.androidmovies
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Result(val results: List<Movie>) : Parcelable


@Parcelize
data class Movie (
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
    val release_date: String,
    val overview: String
) : Parcelable