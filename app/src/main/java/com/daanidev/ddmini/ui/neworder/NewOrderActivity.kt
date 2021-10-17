package com.daanidev.ddmini.ui.neworder

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.daanidev.ddmini.R
import com.daanidev.ddmini.ui.ingredient.IngredientTabActivity
import com.daanidev.ddmini.ui.ingredient.adapter.IngredientTabAdapter
import com.daanidev.ddmini.ui.ingredient.tabs
import com.daanidev.ddmini.ui.neworder.viewmodel.NewOrderViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_new_order.*
import kotlinx.android.synthetic.main.rel_action_bar.*

@AndroidEntryPoint
class NewOrderActivity : AppCompatActivity() {


    private lateinit var navGraph: NavGraph
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_order)
        initializeCustomActionBar()

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        navGraph=navController.navInflater.inflate(R.navigation.nav_new_order)
        navGraph.startDestination=R.id.incomingFragment

    }


    fun initializeCustomActionBar() {

        val actionBar: ActionBar? = this.supportActionBar
        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.setDisplayShowCustomEnabled(true)
        actionBar?.setCustomView(R.layout.rel_action_bar)
        iv_ingredient.setOnClickListener {

            val inn = Intent(this,IngredientTabActivity::class.java)
            startActivity(inn)
        }
/*
        tv_incoming.setOnClickListener {
           navController.navigate(R.id.incomingFragment)
        }

        tv_preparing.setOnClickListener {
          navController.navigate(R.id.preparingFragment)
        }
        tv_collection.setOnClickListener {
         navController.navigate(R.id.collectionFragment)
        }*/


    }

    fun setOrderCount(count:Int)
    {
        if(tv_order_count.visibility== View.GONE)
        {
            tv_order_count.visibility=View.VISIBLE
        }
        tv_order_count.text="$count"
    }
}