package com.ragabz.pokemongo.features

import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.ragabz.pokemongo.R
import com.ragabz.pokemongo.core.BaseDBActivity
import com.ragabz.pokemongo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseDBActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onInitBinding() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
    }

    override fun onInitObserver() {
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) ||
            super.onSupportNavigateUp()
    }
}
