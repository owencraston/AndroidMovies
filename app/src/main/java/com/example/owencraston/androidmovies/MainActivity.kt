package com.example.owencraston.androidmovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val movieApiServe by lazy {
        MovieClient.create()
    }
    var disposable: Disposable? = null

    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager( this , LinearLayoutManager.VERTICAL, false)
        recyclerView_main.adapter = adapter
        //call fetchData
        fetchMovies()
    }

    fun fetchMovies() {
        println("fetching movie data")
        val videoCollection : Result

        disposable = movieApiServe.getMovies("96662", 1, "204bb7c38f35e758cd8918f5a6c38aa7")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->  generateMovieList(result)},
                        { error -> onError(error)}
                    )
    }

    fun onError(throwable: Throwable) {
        val name="hello"
    }

    // dispose of if request fails
    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    // generate list view
    fun generateMovieList(movieCollection : Result) {
        adapter.setData(movieCollection.results)
    }
}
