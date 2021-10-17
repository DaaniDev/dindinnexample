package com.daanidev.ddmini.utils

import android.R.attr
import android.R.attr.colorAccent
import android.app.Activity
import android.content.Context

import android.widget.LinearLayout

import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.daanidev.ddmini.R
import io.reactivex.Flowable
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import android.media.MediaPlayer

import android.media.RingtoneManager
import android.net.Uri


object AppUtils {

    private const val timeFormat="yyyy-MM-dd'T'HH:mm+SS'Z'"
    private val inputFormat = SimpleDateFormat(timeFormat, Locale.ENGLISH)

    fun setupProgressBar(context: Activity, layoutViews: LinearLayout) {


        var width: Int
        val viewsList: ArrayList<View> = ArrayList()
        //for getting dimensions of screen
        //for getting dimensions of screen
        val displayMetrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels

        //suppose we have to cut section into 4 parts
        val numberOfSections = 30
        width -= (18+18 * numberOfSections) //reducing length of layout by 16dp from left and right and in between 16dp {in between*number of sections)

        width /= numberOfSections
        for (i in 0 until 5) {
            val v = View(context)
            val params = LinearLayout.LayoutParams(width, 15)
            params.setMargins(16, 0, 0, 0) //giving 16dp internal margin between two views
            v.layoutParams = params
            v.tag= "progress_item_$i"
            viewsList.add(v) //adding views in array list for changing color on click of button
            v.background=ContextCompat.getDrawable(context,R.drawable.bk_progress_bar)
            layoutViews.addView(v)
        }
    }

    fun calculateCountDown(strTime: String,endTime:String): Long {


        val strDate: Date = inputFormat.parse(strTime)!!
        val endDate: Date = inputFormat.parse(endTime)!!

        Log.wtf("countdown",""+TimeUnit.SECONDS.toSeconds(endDate.time-strDate.time))
        return TimeUnit.SECONDS.toSeconds(endDate.time-strDate.time)

    }

    fun alertTime(strTime: String,alertTime:String):Long{

        val strDate: Date = inputFormat.parse(strTime)!!
        val alertDate: Date = inputFormat.parse(alertTime)!!

        return TimeUnit.MILLISECONDS.toSeconds(alertDate.time-strDate.time)
    }

    fun countdownTimer(remainingTime: Long, interval: Int): Flowable<Int> {
        return Flowable.range(0, interval + 1)
            .map { interval - it }
            .repeat()
            .skip(interval - remainingTime)
            .concatMap { Flowable.just(it).delay(1, TimeUnit.SECONDS) }
    }

    fun playTune(context: Context){
        val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val player: MediaPlayer = MediaPlayer.create(context, notification)
        if(!player.isPlaying)
        {
            player.start()
        }

    }

}