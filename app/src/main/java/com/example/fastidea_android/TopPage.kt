package com.example.fastidea_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_top_page.*

class TopPage : AppCompatActivity() {
    //Realm
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_page)

        // Global変数を使う
        val glob = application as Global

        // Realmの初期化
        Realm.init(this)

        // 「しりとり」ボタンタップ時の処理
        toSiritoriThemeListButton.setOnClickListener {
            // テーマ一覧のActivityにMETHODNAMEを渡して遷移
            val intent = Intent(this, ThemeList::class.java)
            glob.METHOD_NAME = "Siritori"
            startActivity(intent)
        }

        //「まんだら」ボタンタップ時の処理
        toMandaraThemeList.setOnClickListener {
            val intent = Intent(this, ThemeList::class.java)
            glob.METHOD_NAME = "Mandara"
            startActivity(intent)
        }

        // realm インスタンス生成
        realm = Realm.getDefaultInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

}
