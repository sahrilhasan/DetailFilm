package com.sahrilhasan10gmail.kotlinretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GetAPIClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}