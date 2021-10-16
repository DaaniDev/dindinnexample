package com.daanidev.ddmini.ui.neworder

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_order)
        initializeCustomActionBar()

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph=navController.navInflater.inflate(R.navigation.nav_new_order)
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


    }
}