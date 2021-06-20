package com.lotaviods.forFun.animeList.ui.mainactivity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.lotaviods.forFun.animeList.R


class MainActivity : AppCompatActivity() {
    private var navHostFragment: NavHostFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment!!.navController

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

    }
    override fun onSupportNavigateUp(): Boolean {
        return navHostFragment?.navController?.navigateUp()!!
                || super.onSupportNavigateUp()
    }

}