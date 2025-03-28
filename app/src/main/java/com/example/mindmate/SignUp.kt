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

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // navigate to the Login screen.
        val gotoLoginText = findViewById<TextView>(R.id.gotoLoginText)
        gotoLoginText.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_left, R.anim.slide_out_right)
            startActivity(intent, options.toBundle())
            finish() // Optionally finish the SignUp activity
        }

        findViewById<Button>(R.id.signUpButton).setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }

        // Navigate to Login when the "Sign up with Apple" button is clicked
        findViewById<AppCompatButton>(R.id.appleSignUpButton).setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }

        // Navigate to Login when the "Sign up with Google" button is clicked
        findViewById<AppCompatButton>(R.id.googleSignUpButton).setOnClickListener {
            startActivity(Intent(this, LogIn::class.java))
        }
    }
}