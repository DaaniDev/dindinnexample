package com.daanidev.ddmini.ui

import android.os.CountDownTimer
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.daanidev.ddmini.R
import com.daanidev.ddmini.utils.AppUtils
import io.reactivex.Observable
import io.reactivex.Observer

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
    fun setTitle(view: TextView, qty:Int?,text:String?) {

        view.text="$qty $text"
    }

    @JvmStatic
    @BindingAdapter(value = ["protein"])
    fun setProtein(view: TextView, protein:Int) {

        view.text="# Protein ($protein)"
    }

    @JvmStatic
    @BindingAdapter(value = ["accept"])
    fun setAccept(view: TextView, accept:Observable<Boolean>) {

        view.text="Accept"

    }

    @JvmStatic
    @BindingAdapter(value = ["created","alerted","expired"])
    fun timer(view: TextView,created:String,alerted:String,expired:String) {


        val alertTime=AppUtils.alertTime(created,alerted)
        val timer = object : CountDownTimer(
            AppUtils.calculateCountDown(
              created,
                expired
            ), 1000
        ) {
            override fun onTick(millisUntilFinished: Long) {

              view.text = "${millisUntilFinished/1000}s"

                Log.wtf("timeer","$millisUntilFinished $alertTime")
                 if((millisUntilFinished/1000)==alertTime)
                {
                    AppUtils.playTune(view.context)
                }
            }

            override fun onFinish() {

                Log.wtf("timer","ended")

            }

        }
        timer.start()

    }


}