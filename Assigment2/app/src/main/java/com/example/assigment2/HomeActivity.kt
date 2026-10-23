package com.example.assigment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var profileButton: Button
    var isLoginIn: Boolean = false
    var currentUser: User? = null
    private val loginLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
       resul->
        if (resul.resultCode == RESULT_OK)
        {
            val user = resul.data?.getSerializableExtra("USER_KEY") as? User
            if (user != null)
            {
                currentUser = user
                isLoginIn = true
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home_layout)
        profileButton = findViewById(R.id.profileBackButton_id)
        var intent = Intent(this, ProfileActivity::class.java)
        profileButton.setOnClickListener {
            if(isLoginIn){
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra("USER_KEY", currentUser)
                }
                startActivity(intent)
            }else{
                intent = Intent(this, LoginActivity::class.java)
                loginLauncher.launch(intent)
            }
        }

    }
}