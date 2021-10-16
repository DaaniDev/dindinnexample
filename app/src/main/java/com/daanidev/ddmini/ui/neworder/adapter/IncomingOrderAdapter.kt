package com.daanidev.ddmini.ui.neworder.adapter

import android.app.Activity
import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ItemNewOrderBinding
import com.daanidev.ddmini.databinding.ItemOrderSubitemsListBinding
import com.daanidev.ddmini.ui.neworder.model.Addon
import com.daanidev.ddmini.ui.neworder.model.NewOrderResponse
import com.daanidev.ddmini.utils.AppUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.Flow

class IncomingOrderAdapter(val context: Activity) :
    RecyclerView.Adapter<IncomingOrderAdapter.ViewHolder>() {

    private lateinit var titleListAdapter: NewOrderTitleListAdapter
    private var newOrdersList = arrayListOf<NewOrderResponse>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IncomingOrderAdapter.ViewHolder {

        val itemNewOrderBinding: ItemNewOrderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_new_order, parent, false
        )
        return ViewHolder(itemNewOrderBinding)
    }

    override fun getItemCount(): Int {

        return newOrdersList.size
    }

    override fun onBindViewHolder(holder: IncomingOrderAdapter.ViewHolder, position: Int) {

        holder.onBind(position)

    }

    fun addNewOrder(newOrder: NewOrderResponse) {
        this.newOrdersList.add(0, newOrder)
        notifyItemInserted(0)

    }

    inner class ViewHolder(private val itemNewOrderBinding: ItemNewOrderBinding) :
        RecyclerView.ViewHolder(itemNewOrderBinding.root) {

        fun onBind(pos: Int) {

            itemNewOrderBinding.obj = newOrdersList[pos]
            titleListAdapter = NewOrderTitleListAdapter(context, newOrdersList[pos].data)
            itemNewOrderBinding.listNewOrder.apply {
                this.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                this.adapter = titleListAdapter
            }

            AppUtils.setupProgressBar(context, itemNewOrderBinding.progressBar)
            countDownTimer(
                itemNewOrderBinding, newOrdersList[pos].created_at,
                newOrdersList[pos].alerted_at, newOrdersList[pos].expired_at
            )
        }


    }

    private fun countDownTimer(
        itemNewOrderBinding: ItemNewOrderBinding,
        created: String,
        alerted: String,
        expired: String
    ) {

        val totalTime =20000L
        val sectionTime:Double = totalTime/5.0
        var count=4.0
        val alertTime = AppUtils.alertTime(created, alerted)
        val timer = object : CountDownTimer(
            totalTime, 1000
        ) {
            override fun onTick(millisUntilFinished: Long) {

                itemNewOrderBinding.tvOrderAutoRejectTimer.text = "${millisUntilFinished / 1000}s"
                Log.wtf("timeer", "$millisUntilFinished $alertTime")
                if ((millisUntilFinished / 1000) == alertTime) {
                    AppUtils.playTune(context)
                }
            val result : Double = millisUntilFinished/sectionTime
               Log.wtf("result",result.toString())
                Log.wtf("coubt",count.toString())
                if (result==count)
                {

                    val itemTag="progress_item_${4-count.toInt()}"
                    Log.wtf("tag",itemTag)
                    count--
                    itemNewOrderBinding.progressBar.findViewWithTag<View>(itemTag).setBackgroundColor(ContextCompat.getColor(context,R.color.grey))
                }

            }

            override fun onFinish() {

                itemNewOrderBinding.tvOrderAutoRejectTimer.visibility = View.GONE
                itemNewOrderBinding.tvOrderAutoReject.visibility = View.GONE
                itemNewOrderBinding.tvNewOrderAccept.background =
                    ContextCompat.getDrawable(context, R.drawable.bk_btn_auto_reject)


            }

        }
        timer.start()
    }
}