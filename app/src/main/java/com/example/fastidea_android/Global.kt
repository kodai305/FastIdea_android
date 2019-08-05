package com.example.fastidea_android

import android.app.Application
import io.realm.Realm

class Global : Application() {
    // アイデアのメソッド名
    var METHOD_NAME: String = ""

    override fun onCreate() {
        super.onCreate()

        // クラス名が微妙になってくるが、現状の設定(AndroidManifest.xml)ではここで呼ぶと
        // アプリ起動時に1回呼ぶことができるのでここで実行している.
        Realm.init(this)

    }

}