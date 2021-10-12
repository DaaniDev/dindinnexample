package com.daanidev.ddmini.ui.ingredient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.daanidev.ddmini.R
import com.daanidev.ddmini.databinding.ActivityTabIngredientBinding
import com.daanidev.ddmini.ui.ingredient.adapter.IngredientTabAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


val tabs= arrayOf(
    "Bento","Main","Appetizer"
)

@AndroidEntryPoint
class IngredientTabActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTabIngredientBinding
    private lateinit var tabAdapter: IngredientTabAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tab_ingredient)
        initUI()
    }

    private fun initUI(){

        tabAdapter = IngredientTabAdapter(this, tabs.size)
        binding.tabViewPager.adapter=tabAdapter

        TabLayoutMediator(binding.ingredientTabs, binding.tabViewPager) { tab, position ->
            tab.text = tabs[position]

        }.attach()

    }

}