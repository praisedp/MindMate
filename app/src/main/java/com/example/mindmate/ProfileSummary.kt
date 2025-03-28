package com.example.mindmate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileSummary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_summary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // In ProfileSummary.kt, inside onCreate()
        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish() // This will close the ProfileSummary activity and go back to the previous page.
        }

        // In ProfileSummary.kt (or whichever activity uses activity_profile_summary.xml)
        val settingsIcon = findViewById<ImageView>(R.id.settingsIcon)
        settingsIcon.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }
    }
}