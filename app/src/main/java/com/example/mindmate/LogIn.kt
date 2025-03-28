package com.example.mindmate

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gotoSignUpText = findViewById<TextView>(R.id.alreadyAccountText)
        gotoSignUpText.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            // Use a custom animation: sign-up page slides in from left while login page slides out to right.
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent, options.toBundle())
            finish() // Optionally finish the login activity
        }

        findViewById<Button>(R.id.loginButton).setOnClickListener {
            val intent = Intent(this, OnboardingScreen1::class.java)
            // Optional: use custom animations if desired
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent, options.toBundle())
            finish() // Optionally finish this activity
        }

        // Navigate to Onboarding screen when "Sign in with Apple" is clicked
        findViewById<AppCompatButton>(R.id.appleSignInButton).setOnClickListener {
            startActivity(Intent(this, OnboardingScreen1::class.java))
        }

        // Navigate to Onboarding screen when "Sign in with Google" is clicked
        findViewById<AppCompatButton>(R.id.googleSignInButton).setOnClickListener {
            startActivity(Intent(this, OnboardingScreen1::class.java))
        }
    }
}