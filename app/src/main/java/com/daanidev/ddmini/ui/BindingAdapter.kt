package com.daanidev.ddmini.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.daanidev.ddmini.R

object BindingAdapter {

    // display image using glide
    @JvmStatic
    @BindingAdapter(value = ["image"])
    fun loadImage(view: ImageView, url: String?) {

        Glide.with(view.context).load(url).into(view)
    }

    // change availability background using if else statement
    @JvmStatic
    @BindingAdapter(value = ["availabilitybackground"])
    fun availabilityBackground(view: TextView, count:Int) {

        view.background= if(count<10) ContextCompat.getDrawable(view.context,R.drawable.bk_item_ingredient_red) else ContextCompat.getDrawable(view.context,R.drawable.bk_item_ingredient_grey)
    }

    // change count textview backkground using if else statement
    @JvmStatic
    @BindingAdapter(value = ["countbackground"])
    fun countBackground(view: TextView, count:Int) {

        view.background= if(count<10) ContextCompat.getDrawable(view.context,R.drawable.bk_item_ingredient_count_red) else ContextCompat.getDrawable(view.context,R.drawable.bk_item_ingredient_count_grey)


    }

    // since count is in int data type so i need to convert into String to set it on textview
    @JvmStatic
    @BindingAdapter(value = ["count"])
    fun count(view: TextView, count: Int) {

      view.text=count.toString()
    }

    @JvmStatic
    @BindingAdapter(value = ["qty","string"])
    fun setTitle(view: TextView, qty:Int,text:String) {

        view.text="$qty $text"
    }

    @JvmStatic
    @BindingAdapter(value = ["protein"])
    fun setProtein(view: TextView, protein:Int) {

        view.text="# Protein ($protein)"
    }

}