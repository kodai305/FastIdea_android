package com.example.fastidea_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_theme_list.*

class ThemeList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_list)

        // トップ画面からの遷移時に受け取ったMETHOD_NAMEを取得
        methodName.text = intent.getStringExtra(KeyManager.METHOD_NAME)

        // 上のバーの左端に戻るボタンを表示
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // METHODNAMEを取得出来たかの確認用
        // TODO:実装が進んだら消す
        supportActionBar?.title = "ThemeList"
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
