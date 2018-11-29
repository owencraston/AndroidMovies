package com.example.owencraston.androidmovies

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import io.reactivex.Observable;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.Headers
import retrofit2.http.Path


interface MovieClient {

    @GET("list/{list_id}")
    fun getMovies(@Path("list_id") list_id: String,
                  @Query("page") page: Int,
                  @Query("api_key") api_key: String): Observable<Result>

    /**
     * Companion object to create the MovieClient
     */

    companion object {
        fun create(): MovieClient {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/4/")
                .build()
            return retrofit.create(MovieClient::class.java)
        }
    }
}