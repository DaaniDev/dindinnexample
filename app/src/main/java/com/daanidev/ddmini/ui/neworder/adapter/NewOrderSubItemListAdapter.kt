package com.daanidev.ddmini.ui.neworder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ItemOrderSubitemsListBinding
import com.daanidev.ddmini.databinding.ItemOrderTitleListBinding
import com.daanidev.ddmini.ui.neworder.model.Addon
import com.daanidev.ddmini.ui.neworder.model.Data

class NewOrderSubItemListAdapter(val subItemList: List<Addon>) : RecyclerView.Adapter<NewOrderSubItemListAdapter.ViewHolder>() {


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

        return subItemList.size
    }

    override fun onBindViewHolder(holder: NewOrderSubItemListAdapter.ViewHolder, position: Int) {

        holder.onBind(position)

    }

    inner class ViewHolder(private val itemOrderSubitemsListBinding: ItemOrderSubitemsListBinding) :
        RecyclerView.ViewHolder(itemOrderSubitemsListBinding.root) {

        fun onBind(pos:Int){

            if(pos==0)
            {
                itemView.visibility=View.VISIBLE
                itemOrderSubitemsListBinding.obj=subItemList[pos]
            }
            else{
                itemView.visibility= View.GONE

            }

        }
    }
}