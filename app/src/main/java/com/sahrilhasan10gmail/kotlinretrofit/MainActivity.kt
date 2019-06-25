package com.sahrilhasan10gmail.kotlinretrofit

import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.sahrilhasan10gmail.kotlinretrofit.adapter.MovieAdapter
import com.sahrilhasan10gmail.kotlinretrofit.network.GetAPIClient
import com.sahrilhasan10gmail.kotlinretrofit.model.MovieList
import com.sahrilhasan10gmail.kotlinretrofit.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var linearLayoutManager: LinearLayoutManager? = null
    var recyclerView: RecyclerView? = null
    var responseMovies: MutableList<Result>? = null
    var listMovieAdapter: MovieAdapter? = null
    var apiClient: GetAPIClient? = null
    var api_key: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        responseMovies = ArrayList()

        recyclerView = findViewById(R.id.rv_listmovieDB)
        recyclerView?.setHasFixedSize(true)

        apiClient = GetAPIClient()

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.setLayoutManager(linearLayoutManager)

        listMovieAdapter = MovieAdapter()
        recyclerView?.setAdapter(listMovieAdapter)

        api_key = getString(R.string.api_key)

        doAPICallMovie()
    }

    private fun doAPICallMovie() {
        apiClient?.getAPIInterface()?.getDataMovieUpcoming(api_key)?.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Toast.makeText(getApplicationContext(), "Get Movie List Failed", Toast.LENGTH_SHORT).show();

            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                listMovieAdapter?.setDataMovies(response!!.body()!!.results as MutableList<Result>?)
            }

        })
    }
}