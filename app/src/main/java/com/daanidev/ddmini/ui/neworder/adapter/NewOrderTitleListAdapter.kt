package com.daanidev.ddmini.ui.neworder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ItemIngredientBinding
import com.daanidev.ddmini.databinding.ItemOrderTitleListBinding
import com.daanidev.ddmini.ui.ingredient.adapter.IngredientListAdapter
import com.daanidev.ddmini.ui.ingredient.model.IngredientList
import com.daanidev.ddmini.ui.neworder.model.Data

class NewOrderTitleListAdapter(val context:Context): RecyclerView.Adapter<NewOrderTitleListAdapter.ViewHolder>() {


    private var titleList= listOf<Data>()
    private lateinit var subItemListAdapter: NewOrderSubItemListAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewOrderTitleListAdapter.ViewHolder {

        val itemOrderTitleListBinding: ItemOrderTitleListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_order_title_list, parent, false
        )
        return ViewHolder(itemOrderTitleListBinding)
    }

    override fun getItemCount(): Int {

        return 1
    }

    override fun onBindViewHolder(holder: NewOrderTitleListAdapter.ViewHolder, position: Int) {

        holder.bind(position)

    }

    fun setList(titleList:List<Data>){

        this.titleList=titleList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val itemOrderTitleListBinding: ItemOrderTitleListBinding) :
        RecyclerView.ViewHolder(itemOrderTitleListBinding.root) {

        fun bind(pos:Int){

          //  itemOrderTitleListBinding.obj=titleList[pos]
            subItemListAdapter = NewOrderSubItemListAdapter()
            itemOrderTitleListBinding.listItemTitle.apply {
                this.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
                this.adapter=subItemListAdapter
            }
          //  subItemListAdapter.setList(titleList[pos].addon)


        }

    }
}