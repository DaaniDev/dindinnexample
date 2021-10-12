package com.daanidev.ddmini.ui.neworder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ItemOrderSubitemsListBinding
import com.daanidev.ddmini.databinding.ItemOrderTitleListBinding
import com.daanidev.ddmini.ui.neworder.model.Addon
import com.daanidev.ddmini.ui.neworder.model.Data

class NewOrderSubItemListAdapter : RecyclerView.Adapter<NewOrderSubItemListAdapter.ViewHolder>() {


    private var subItemList = listOf<Addon>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewOrderSubItemListAdapter.ViewHolder {

        val itemOrderSubitemsListBinding: ItemOrderSubitemsListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_order_subitems_list, parent, false
        )
        return ViewHolder(itemOrderSubitemsListBinding)
    }

    override fun getItemCount(): Int {

        return 1
    }

    override fun onBindViewHolder(holder: NewOrderSubItemListAdapter.ViewHolder, position: Int) {



    }

    fun setList(subItemList: List<Addon>) {

        this.subItemList = subItemList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val itemOrderSubitemsListBinding: ItemOrderSubitemsListBinding) :
        RecyclerView.ViewHolder(itemOrderSubitemsListBinding.root) {


    }
}