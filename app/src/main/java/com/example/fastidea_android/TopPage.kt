package com.example.fastidea_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_top_page.*

class TopPage : AppCompatActivity() {
    companion object {
        const val METHODNAME = "com.fastIdea.methodName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_page)

        toSiritoriThemeListButton.setOnClickListener {
            val intent = Intent(this, ThemeList::class.java)
            intent.putExtra(METHODNAME, "Siritori")
            startActivity(intent)
        }

        toMandaraThemeList.setOnClickListener {
            val intent = Intent(this, ThemeList::class.java)
            intent.putExtra(METHODNAME, "Mandara")
            startActivity(intent)
        }
    }
}
