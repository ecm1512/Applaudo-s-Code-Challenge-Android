package com.educode.applaudocodechallengeandroid.presentation.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.educode.applaudocodechallengeandroid.R
import com.educode.applaudocodechallengeandroid.databinding.ActivitySigninBinding
import com.educode.applaudocodechallengeandroid.presentation.home.MainActivity

class SigninActivity : AppCompatActivity() {

    lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}