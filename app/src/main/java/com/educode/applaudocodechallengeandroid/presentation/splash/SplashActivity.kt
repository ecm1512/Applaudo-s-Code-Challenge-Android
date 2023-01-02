package com.educode.applaudocodechallengeandroid.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.educode.applaudocodechallengeandroid.R
import com.educode.applaudocodechallengeandroid.presentation.signin.SigninActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launch{
            delay(5000)
            startActivity(Intent(applicationContext,SigninActivity::class.java))
            finish()
        }
    }
}