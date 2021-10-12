package com.daanidev.ddmini.ui.ingredient.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.daanidev.ddmini.ui.ingredient.fragment.AppetizerFragment
import com.daanidev.ddmini.ui.ingredient.fragment.BentoFragment
import com.daanidev.ddmini.ui.ingredient.fragment.MainFragment

class IngredientTabAdapter(fm: FragmentActivity, private val tabCount: Int) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> BentoFragment()
            1 -> MainFragment()
            else -> AppetizerFragment()
        }
    }
}