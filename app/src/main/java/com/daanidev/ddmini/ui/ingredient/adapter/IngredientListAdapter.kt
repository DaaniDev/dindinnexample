package com.daanidev.ddmini.ui.ingredient.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ItemIngredientBinding
import com.daanidev.ddmini.ui.ingredient.model.IngredientList

class IngredientListAdapter (val clickCallback:()->Unit): RecyclerView.Adapter<IngredientListAdapter.ViewHolder>() {


    private var ingredientList= listOf<IngredientList>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientListAdapter.ViewHolder {

        val itemIngredientBinding: ItemIngredientBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_ingredient, parent, false
        )
        return ViewHolder(itemIngredientBinding)
    }

    override fun getItemCount(): Int {

        return ingredientList.size
    }

    override fun onBindViewHolder(holder: IngredientListAdapter.ViewHolder, position: Int) {

        holder.bind(position)

    }

    fun setList(ingredientList:List<IngredientList>){

        this.ingredientList=ingredientList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemIngredientBinding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(itemIngredientBinding.root) {
        private val itemIngredientBinding = itemIngredientBinding

        fun bind(pos:Int){

           itemIngredientBinding.obj=ingredientList[pos]

        }

    }
}