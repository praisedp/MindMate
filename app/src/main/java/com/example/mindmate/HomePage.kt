package com.example.mindmate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        // Set Home as selected
        bottomNavigation.selectedItemId = R.id.nav_home

        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Already on HomePage
                    true
                }
                R.id.nav_play -> {
                    startActivity(Intent(this, Meditate::class.java))
                    true
                }
                R.id.nav_moon -> {
                    startActivity(Intent(this, SleepPage::class.java))
                    true
                }
                R.id.nav_book -> {
                    startActivity(Intent(this, Journal::class.java))
                    true
                }
                else -> false
            }
        }

    }
}