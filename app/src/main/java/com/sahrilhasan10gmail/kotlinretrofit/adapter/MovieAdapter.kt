package com.sahrilhasan10gmail.kotlinretrofit.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sahrilhasan10gmail.kotlinretrofit.R
import com.sahrilhasan10gmail.kotlinretrofit.model.MovieList

class MovieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var responMoview : MutableList<MovieList>? = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
     val itemLayout = R.layout.listmovieitem
        val itemViewProject = LayoutInflater.from(parent.context)
            .inflate(itemLayout,parent,false)
        return MyViewHolder(itemViewProject)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
    override fun getItemCount(): Int {
        if (responMoview !=null){
        return responMoview?.size!!
        }else return 0
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        //memanggil adapter
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}