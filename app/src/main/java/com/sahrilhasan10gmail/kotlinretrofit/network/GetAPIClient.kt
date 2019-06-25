package com.sahrilhasan10gmail.kotlinretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.app.Application
import android.content.Context

class GetAPIClient {
    private var retrofit: Retrofit
    var apiInterface: GetAPIinterface? = null

    val BASEURL = "https://api.themoviedb.org/3/"

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create<GetAPIinterface>(GetAPIinterface::class.java)
    }

    fun getAPIInterface(): GetAPIinterface? {
        return apiInterface
    }

}