package com.example.fastidea_android

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class Global : Application() {
    // アイデアのメソッド名
    var METHOD_NAME: String = ""

    override fun onCreate() {
        super.onCreate()

        // クラス名が微妙になってくるが、現状の設定(AndroidManifest.xml)ではここで呼ぶと
        // アプリ起動時に1回呼ぶことができるのでここで実行している.
        Realm.init(this)
        // オブジェクト追加時などマイグレーションが必要な場合にRealmを削除
        // TODO:本番では旧データのバックアップ方法が必要
        val config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)

    }

}