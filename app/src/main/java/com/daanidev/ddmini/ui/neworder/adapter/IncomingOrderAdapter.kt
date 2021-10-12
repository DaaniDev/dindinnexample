package com.daanidev.ddmini.ui.neworder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ItemNewOrderBinding
import com.daanidev.ddmini.databinding.ItemOrderSubitemsListBinding
import com.daanidev.ddmini.ui.neworder.model.Addon

class IncomingOrderAdapter(val context:Context) : RecyclerView.Adapter<IncomingOrderAdapter.ViewHolder>() {

    private lateinit var titleListAdapter: NewOrderTitleListAdapter
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

        return 2
    }

    override fun onBindViewHolder(holder: IncomingOrderAdapter.ViewHolder, position: Int) {

        holder.onBind()

    }



    inner class ViewHolder(private val itemNewOrderBinding: ItemNewOrderBinding) :
        RecyclerView.ViewHolder(itemNewOrderBinding.root) {

        fun onBind(){

            titleListAdapter = NewOrderTitleListAdapter(context)
            itemNewOrderBinding.listNewOrder.apply {
                this.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                this.adapter=titleListAdapter
            }
        }


    }
}