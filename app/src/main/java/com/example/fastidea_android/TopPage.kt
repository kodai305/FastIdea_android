package com.example.fastidea_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_top_page.*
import java.security.Key

class TopPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_page)

        // 「しりとり」ボタンタップ時の処理
        toSiritoriThemeListButton.setOnClickListener {
            // テーマ一覧のActivityにMETHODNAMEを渡して遷移
            val intent = Intent(this, ThemeList::class.java)
            intent.putExtra(KeyManager.METHOD_NAME, "Siritori")
            startActivity(intent)
        }

        //「まんだら」ボタンタップ時の処理
        toMandaraThemeList.setOnClickListener {
            val intent = Intent(this, ThemeList::class.java)
            intent.putExtra(KeyManager.METHOD_NAME, "Mandara")
            startActivity(intent)
        }
    }
}
