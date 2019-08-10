package com.example.fastidea_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.fastidea_android.R
import kotlinx.android.synthetic.main.activity_siritori.*

class Siritori : AppCompatActivity(), SiritoriMainListViewHolder.CellTappedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_siritori)

        // RecycleViewの初期設定
        siritori_main_recycler.adapter = SiritoriMainListViewAdapter(this.createDataList(),this)
        siritori_main_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun createDataList(): List<SiritoriMainData> {

        // TODO:Realmから呼び出したデータを格納する
        val dataList = mutableListOf<SiritoriMainData>()
        for (i in 0..49) {
            val data = SiritoriMainData()
            data.keyWord = i.toString() + "番目のキーワード"
            data.idea = i.toString() + "番目のアイデア"
            dataList.add(data)
        }
        return dataList
    }

    // 各Cellをタップした時の処理
    override fun onCellTapped(tappedView: View, data: SiritoriMainData) {
        Toast.makeText(applicationContext, "position" + data.idea + "was tapped", Toast.LENGTH_SHORT).show()
    }
}
