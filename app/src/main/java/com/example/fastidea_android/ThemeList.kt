package com.example.fastidea_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_theme_list.*

class ThemeList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_list)

        methodName.text = intent.getStringExtra(TopPage.METHODNAME)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "ThemeList"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
