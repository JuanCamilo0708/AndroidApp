package com.example.assigment2

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat

class ProfileActivity : AppCompatActivity() {
    lateinit var profilePicture: ImageView
    lateinit var profileName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile_layout)
        val circleBorder = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setStroke(6, Color.parseColor("#AB3AC5"))
            setColor(Color.TRANSPARENT)
        }
        profileName = findViewById(R.id.profileName_id)
        profilePicture = findViewById(R.id.profilePicture_id)
        profilePicture.background = circleBorder
        profilePicture.clipToOutline = true
        profilePicture.setPadding(10, 10, 10, 10)

        val user = IntentCompat.getSerializableExtra(intent, "USER_KEY", User::class.java)
        if (user != null) {
            profileName.text = user.name
        }

        var backButton: Button = findViewById(R.id.profileBackButton_id)
        backButton.setOnClickListener {
            finish()
        }
    }
}
