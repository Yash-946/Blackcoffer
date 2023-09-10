package com.example.blackcoffer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbar :androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Bottom Navigation
        val exploreFragments = Explore()
        val networkFragments = Network()
        val chatFragments = Chat()
        val contactsFragments = Contacts()
        val groupsFragments = Groups()
        setCurrentFragment(exploreFragments)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.explore -> setCurrentFragment(exploreFragments)
                R.id.network -> setCurrentFragment(networkFragments)
                R.id.chat -> setCurrentFragment(chatFragments)
                R.id.contacts -> setCurrentFragment(contactsFragments)
                R.id.group -> setCurrentFragment(groupsFragments)
            }
            true
        }

//      Navigation Drawer
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.nav_icon)

        //Refine
        val refineBtn = findViewById<ImageButton>(R.id.refine)
        refineBtn.setOnClickListener {
            val intent = Intent(this,Refine::class.java)
            startActivity(intent)
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment)
            commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
}