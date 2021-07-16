package com.anggarad.dev.foodfinder

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.anggarad.dev.foodfinder.databinding.ActivityMainBinding
import com.anggarad.dev.foodfinder.home.HomeFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
            supportActionBar?.title = "Food Finder"
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = "Food Finder"
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = "FoodFinder"
            }

            R.id.nav_favorite -> {
                startActivity(
                    Intent(
                        this,
                        Class.forName("com.anggarad.dev.favorite.FavoriteActivity")
                    )
                )
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}