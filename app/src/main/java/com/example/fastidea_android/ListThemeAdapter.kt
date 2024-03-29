package com.example.fastidea_android

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import io.realm.Realm
import io.realm.RealmResults

class ListThemeAdapter(context: Context,methodName: String, private val onItemClicked: (String) -> Unit) : RecyclerView.Adapter<ListThemeHolder>() {
    var method = methodName

    // realm インスタンス生成
    var realm = Realm.getDefaultInstance()

    // 保存されているテーマ
    //private val themes = arrayOf("テーマ1", "テーマ2", "テーマ3") //TODO: getThemeList()とかに変更する
    //private val themes = getSiritoriThemeList()?.toTypedArray()
    private val themes = getThemes()


    // レイアウトからビューを生成するInflater
    private val inflater = LayoutInflater.from(context)

    // 必須のメソッド
    override fun getItemCount(): Int {
        if (themes == null)
            return 0
        else
            return themes.size
    }


    // 必須のメソッド, 表示するべき値をViewにセットする
    override fun onBindViewHolder(holder: ListThemeHolder, position: Int) {
        // 位置に応じたテーマを得る
        val theme = themes?.get(position)
        // 表示内容を更新する
        holder.theme.text = theme.toString()
    }

    // 必須のメソッド, 新しくViewを作る時に呼ばれる
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListThemeHolder {
        // Viewを生成する
        val view = inflater.inflate(R.layout.list_theme_row, parent, false)

        // ViewHolderを作る
        val viewHolder = ListThemeHolder(view)

        // viewをタップしたときの処理
        view.setOnClickListener {
            // アダプター上の位置を得る
            val position = viewHolder.adapterPosition
            // 位置をもとに、タイムゾーンを得る
            val theme = themes?.get(position)
            // コールバックを呼び出す
            onItemClicked(theme.toString())
        }

        return viewHolder
    }

    fun getSiritoriThemeList(): RealmResults<SiritoriObj>? {
        val siritoriObjs = realm.where(SiritoriObj::class.java).findAll()
        return siritoriObjs
    }

    fun getMandaraThemeList(): RealmResults<MandaraObj>? {
        val mandaraObjs = realm.where(MandaraObj::class.java).findAll()
        return mandaraObjs
    }

    fun getThemes(): MutableList<String> {
        val themes = mutableListOf<String>()
        when (method) {
            "Siritori" -> {
                val SiritoriObjs = getSiritoriThemeList()
                if (SiritoriObjs != null) {
                    SiritoriObjs.forEach {
                        Log.d("TAG", it.theme)
                        themes.add(it.theme)
                    }
                }
                return themes
            }
            "Mandara" -> {
                val MandaraObjs = getMandaraThemeList()
                if (MandaraObjs != null) {
                    MandaraObjs.forEach {
                        Log.d("TAG", it.theme)
                        themes.add(it.theme)
                    }
                }
                return themes
            }
            else -> {
                return themes
            }
        }
    }
}