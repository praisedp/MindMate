package com.example.mindmate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Meditate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meditate)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        // Set Meditate as selected
        bottomNavigation.selectedItemId = R.id.nav_play

        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomePage::class.java))
                    true
                }
                R.id.nav_play -> {
                    // Already on Meditate
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

        // In Meditate.kt, inside onCreate()
        val medStartButton1 = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.startButtonMedCard1)
        val medStartButton2 = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.startButtonMedCard2)

        medStartButton1.setOnClickListener {
            startActivity(Intent(this, Music::class.java))
        }

        medStartButton2.setOnClickListener {
            startActivity(Intent(this, Music::class.java))
        }
        findViewById<ImageView>(R.id.dailyCalmImage).setOnClickListener {
            startActivity(Intent(this, Course::class.java))
        }
    }
}