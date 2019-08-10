package com.example.fastidea_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
//import com.example.fastidea_android.TopPage.Companion.METHODNAME
import kotlinx.android.synthetic.main.activity_theme_list.*

class ThemeList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_list)

        // Global変数
        val glob = application as Global

        // トップ画面からの遷移時に受け取ったMETHODNAMEを取得
        methodName.text = glob.METHOD_NAME

        // 上のバーの左端に戻るボタンを表示
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // METHODNAMEを取得出来たかの確認用
        // TODO:実装が進んだら消す
        supportActionBar?.title = "ThemeList"

        // 新規作成ボタンを押下したら、テーマ入力画面に画面遷移
        val button = findViewById<Button>(R.id.create_theme_button)
        button.setOnClickListener {
            val intent = Intent(this, InputTheme::class.java)
            startActivity(intent)
        }

        // RecyclerViewをレイアウトから探す
        val recyclerView = findViewById<RecyclerView>(R.id.themeList)

        // タイムゾーンリスト用のアダプター
        val adapter = ListThemeAdapter(this, glob.METHOD_NAME) { theme: String ->
            Toast.makeText(this, theme, Toast.LENGTH_SHORT).show()
        }
        adapter.method = glob.METHOD_NAME

        // RecyclerViewにアダプターをセットする
        recyclerView.adapter = adapter

        // 縦に直線的に表示するレイアウトマネージャーをセットする
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    // 上のバーの戻るボタンの処理
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
