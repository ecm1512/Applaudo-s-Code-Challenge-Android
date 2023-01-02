package com.educode.applaudocodechallengeandroid

import android.app.Application
import com.educode.applaudocodechallengeandroid.module.initDI

class ApplaudoApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}