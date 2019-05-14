package com.sahrilhasan10gmail.kotlinretrofit.network

import com.sahrilhasan10gmail.kotlinretrofit.model.MovieList
import retrofit2.Call
import retrofit2.http.QueryMap
import retrofit2.http.GET
import retrofit2.http.Query


interface GetAPIinterface {
    @GET("movie/upcoming")
    fun groupList(@Query("sort") sort: String): Call<MovieList>
}