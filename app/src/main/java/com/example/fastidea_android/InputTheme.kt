package com.example.fastidea_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import io.realm.Realm
import io.realm.RealmObject
import kotlinx.android.synthetic.main.activity_input_theme.*
import java.util.*

class InputTheme : AppCompatActivity() {
    // realm インスタンス生成
    var realm = Realm.getDefaultInstance()

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

            // theme_text
            var theme : String = ""
            val themeView = findViewById<EditText>(R.id.theme_text)
            if(themeView.text != null){
                theme = themeView.text.toString()
            }
            // 挿入
            insertMandaraObj(theme)

            // 検索(テスト)
            readMandaraObj()

            when (glob.METHOD_NAME) {
                // DBのidを渡すべき??

                // しりとり法の画面へ遷移
                "Siritori" -> intent = Intent(this, Siritori::class.java)

                // マンダラチャートの画面へ遷移
                "Mandara"  -> intent = Intent(this, Mandara::class.java)

                //条件にヒットしない場合はトップに戻る
                else       -> intent = Intent(this, TopPage::class.java)
            }
            startActivity(intent)
        }
    }

    // XXX: これらのメソッドをどこに持たせるか
    // Opt1: 現状維持
    // Opt2: MandaraObjDao みたいなものを作る
    // Opt3: MandaraObjに関数をもたせる->違う気がする
    // -> Opt2かなと思うが一旦保留

    fun insertMandaraObj(theme: String) {
        realm.executeTransaction {
            val mandaraObj = MandaraObj()
            mandaraObj.id = UUID.randomUUID().toString();
            mandaraObj.theme = theme
            realm.insert(mandaraObj)
        }
    }

    fun readMandaraObj() {
        var mandaraObj = realm.where(MandaraObj::class.java).findAll()
        Log.d("TAG",mandaraObj.toString())
    }
}