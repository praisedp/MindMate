package com.example.mindmate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CheckMyMood3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("CheckMyMood3", "onCreate started")
        setContentView(R.layout.activity_check_my_mood3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Back button: finishes the current activity.
        findViewById<ImageView>(R.id.backButton).setOnClickListener {
            finish()
        }

        // First Start Button: Navigate to Music page.
        findViewById<AppCompatButton>(R.id.startButtonMedCard1).setOnClickListener {
            startActivity(Intent(this, Music::class.java))
        }

        // Second Start Button: Navigate to Course page.
        findViewById<AppCompatButton>(R.id.startButtonMedCard2).setOnClickListener {
            startActivity(Intent(this, Course::class.java))
        }

        // Daily Calm Image: Navigate to Course page.
        findViewById<ImageView>(R.id.dailyCalmImage).setOnClickListener {
            startActivity(Intent(this, Course::class.java))
        }

        // Daily Thought Image: Navigate to Course page.
        findViewById<ImageView>(R.id.dailyThoughtImage).setOnClickListener {
            startActivity(Intent(this, Course::class.java))
        }

        // Cone Button: Navigate to Meditate page.
        // Make sure you have an ImageView with id coneButton in your layout.
        findViewById<AppCompatButton>(R.id.done).setOnClickListener {
            startActivity(Intent(this, Meditate::class.java))
        }
    }
}