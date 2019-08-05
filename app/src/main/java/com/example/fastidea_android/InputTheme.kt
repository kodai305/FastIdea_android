package com.example.fastidea_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_input_theme.*

class InputTheme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_theme)

        // Global変数を使う
        val glob = application as Global

        // textにメソッド名を表示
        method_name.text = "メソッド名: " + glob.METHOD_NAME

        // 作成ボタンを押下したら、それぞれの手法画面に遷移
        val button = findViewById<Button>(R.id.create_theme_button)
        button.setOnClickListener {
            val intent: Intent
            when(glob.METHOD_NAME){
                "Siritori" -> intent = Intent(this, Siritori::class.java)
                "Mandara"  -> intent = Intent(this, Mandara::class.java)
                //条件にヒットしない場合はトップに戻る
                else       -> intent = Intent(this, TopPage::class.java)
            }
            startActivity(intent)
        }
    }
}