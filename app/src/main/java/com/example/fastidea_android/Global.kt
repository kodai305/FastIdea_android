package com.example.fastidea_android

import android.app.Application

class Global : Application() {
    // アイデアのメソッド名
    var METHOD_NAME: String = ""

    override fun onCreate() {
        super.onCreate()
    }
}