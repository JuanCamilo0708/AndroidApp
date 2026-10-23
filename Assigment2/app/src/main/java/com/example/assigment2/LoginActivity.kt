package com.example.assigment2

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_layout)
        email = findViewById(R.id.email_id)
        password = findViewById(R.id.password_id)
        loginButton = findViewById(R.id.loginButton_id)
        val roundedBackgroundText = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setStroke(4, Color.parseColor("#AB3AC5"))
            cornerRadius = 100f
        }
        val buttonGradient = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            colors = intArrayOf(
                Color.parseColor("#AB3AC5"),
                Color.parseColor("#5A117F")
            )
            orientation = GradientDrawable.Orientation.LEFT_RIGHT
            cornerRadius = 50f
        }

        email.background = roundedBackgroundText
        email.setPadding(50,50,20,50)
        password.background = roundedBackgroundText
        password.setPadding(50,50,0,50)
        loginButton.backgroundTintList = null
        loginButton.background = buttonGradient
        loginButton.setOnClickListener {
            login(it)
        }
    }
    fun login(view: View)
    {
        val inputEmail = email.text.toString().trim()
        val inputPassword = password.text.toString().trim()

        val foundUser = AppData.array.find {
            user-> user.email.equals(inputEmail, ignoreCase = true) &&
            user.password == inputPassword
        }

        if (foundUser != null)
        {
            val resultIntent = Intent().apply {
                putExtra("USER_KEY" , foundUser)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }else
        {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
    }
}