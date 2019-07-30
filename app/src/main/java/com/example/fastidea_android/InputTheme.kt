package com.example.fastidea_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_input_theme.*

class InputTheme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_theme)

        // Global変数を使う
        val glob = application as Global

        // textにメソッド名を表示
        method_name.text = "メソッド名: " + glob.METHOD_NAME
    }
}