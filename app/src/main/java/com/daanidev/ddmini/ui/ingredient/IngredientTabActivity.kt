package com.daanidev.ddmini.ui.ingredient

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

    private lateinit var editTextValueListener: EditTextValueListener
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

        binding.etSearchIngredient.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                editTextValueListener.onChange(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    fun setListener(editTextValueListener: EditTextValueListener)
    {
        this.editTextValueListener=editTextValueListener
    }

}