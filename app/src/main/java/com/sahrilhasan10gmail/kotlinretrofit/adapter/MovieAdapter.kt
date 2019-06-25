package com.sahrilhasan10gmail.kotlinretrofit.adapter

import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sahrilhasan10gmail.kotlinretrofit.DetailFilmActivity
import com.sahrilhasan10gmail.kotlinretrofit.R
import com.sahrilhasan10gmail.kotlinretrofit.glide.GlideApp
import com.sahrilhasan10gmail.kotlinretrofit.model.Result
import kotlinx.android.synthetic.main.listmovieitem.view.*
import retrofit2.http.Url
import java.net.URL

class MovieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var responseMovie: MutableList<Result>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemLayout = R.layout.listmovieitem
        val itemViewProject = LayoutInflater.from(parent.context)
            .inflate(itemLayout, parent, false)
        return MyViewHolder(itemViewProject)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        if (responseMovie != null) {
            return responseMovie?.size!!
        } else return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mResponseMovie = responseMovie?.get(position)
        val context = holder.itemView.context


        val imageMovie = mResponseMovie?.backdropPath

        Log.d("MovieAdapter", imageMovie)

        val url = "http://image.tmdb.org/t/p/w185/" + imageMovie

        GlideApp.with(context)
            .load(url)
            .into(holder.itemView.imageviewlist)
//
        holder.itemView.textviewtitle.text = mResponseMovie?.title
        holder.itemView.textviewpopuler.text = mResponseMovie?.popularity.toString()
        holder.itemView.btndetail.setOnClickListener {
            val intent = Intent(context,DetailFilmActivity::class.java)
            intent.putExtra("NAMAFILM",mResponseMovie?.title)
            context.startActivity(intent)
 //
        }

    }

    fun setDataMovies(responseMovies: MutableList<com.sahrilhasan10gmail.kotlinretrofit.model.Result>?){
        this.responseMovie = responseMovies
        notifyDataSetChanged()
    }
}