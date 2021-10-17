package com.daanidev.ddmini.ui.neworder.adapter

import android.app.Activity
import android.content.Context
import android.os.CountDownTimer
import android.system.Os.accept
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.util.Consumer
import androidx.core.util.Predicate
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
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.ceil
import kotlin.math.floor

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
                itemNewOrderBinding,this, newOrdersList[pos].created_at,
                newOrdersList[pos].alerted_at, newOrdersList[pos].expired_at
            )
            itemNewOrderBinding.tvOrderNum.text="#${newOrdersList[pos].order_id}"
            itemNewOrderBinding.tvOrderTime.text=newOrdersList[pos].time
            itemNewOrderBinding.tvNewOrderCount.text="${newOrdersList[pos].data.size} items"

        }


    }

    private fun countDownTimer(
        itemNewOrderBinding: ItemNewOrderBinding,
        holder:IncomingOrderAdapter.ViewHolder,
        created: String,
        alerted: String,
        expired: String
    ) {

        val totalTime =AppUtils.calculateCountDown(created,expired)
        val sectionTime:Double = totalTime/5.0
        var count=4.0
        val alertTime = AppUtils.alertTime(created, alerted)
        val timer = object : CountDownTimer(
            totalTime, 100
        ) {
            override fun onTick(millisUntilFinished: Long) {

                itemNewOrderBinding.tvOrderAutoRejectTimer.text = "${millisUntilFinished / 1000}s"
                Log.wtf("timeer", "$millisUntilFinished $alertTime")
                if ((millisUntilFinished / 1000) == alertTime) {
                    AppUtils.playTune(context)
                }
            val result : Double = ceil(millisUntilFinished/sectionTime)
                if (result==count)
                {

                    val itemTag="progress_item_${4-count.toInt()}"
                    Log.wtf("tag",itemTag)
                    count--
                    itemNewOrderBinding.progressBar.findViewWithTag<View>(itemTag).background=ContextCompat.getDrawable(context,R.drawable.bk_progress_bar_grey)
                }

            }

            override fun onFinish() {

                itemNewOrderBinding.tvOrderAutoRejectTimer.visibility = View.INVISIBLE
                itemNewOrderBinding.tvOrderAutoReject.visibility = View.INVISIBLE
                itemNewOrderBinding.progressBar.visibility=View.INVISIBLE
                itemNewOrderBinding.tvNewOrderAccept.background = ContextCompat.getDrawable(context, R.drawable.bk_btn_auto_reject)
                itemNewOrderBinding.tvNewOrderAccept.text=context.resources.getString(R.string.str_ok)
                itemNewOrderBinding.tvNewOrderAccept.setTextColor(ContextCompat.getColor(context,R.color.black))


            }

        }
        timer.start()


        itemNewOrderBinding.tvNewOrderAccept.setOnClickListener {

            newOrdersList.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            if(itemNewOrderBinding.tvNewOrderAccept.text.equals(context.resources.getString(R.string.str_accept)))
            {
              timer.cancel()
            }



        }
    }

}