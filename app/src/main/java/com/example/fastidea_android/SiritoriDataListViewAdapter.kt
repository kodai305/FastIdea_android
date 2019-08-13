package com.example.fastidea_android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SiritoriDataListViewAdapter(private val siritoriDataList: ArrayList<SiritoriData>, private val listener: SiritoriDataListViewHolder.CellTappedListener) : RecyclerView.Adapter<SiritoriDataListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiritoriDataListViewHolder {
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.siritori_main_list_cell, parent, false)
        return SiritoriDataListViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: SiritoriDataListViewHolder, position: Int) {
        // EditTextの初期値を設定
        holder.keywordView.setText(siritoriDataList[position].keyWord, TextView.BufferType.NORMAL)
        holder.ideaView.setText(siritoriDataList[position].idea, TextView.BufferType.NORMAL)

        // 新しく作られるセルでは、ボタンをタップした時の挙動を設定
        if (position == siritoriDataList.count() -1 ) {
            holder.addKeywordButton.setOnClickListener{
                // 一番下のキーワードを保存
                this.saveLatestKeyword(holder.keywordView, position)
                val newKeywordHeadString = this.getNextKeywordHeadString(holder.keywordView)
                this.addKeyword(newKeywordHeadString)
            }
        } else {
            // 一番下のView以外はキーワードの編集を不可に
            holder.keywordView.setEnabled(false)
            // 一番下のView以外はボタンを非表示
            holder.addKeywordButton.setVisibility(View.INVISIBLE)
        }
        holder.itemView.setOnClickListener {
            listener.onCellTapped(it, siritoriDataList[position])
        }
    }

    override fun getItemCount(): Int {
        return siritoriDataList.size
    }

    private fun saveLatestKeyword(currentKeywordView: EditText, position: Int) {
        siritoriDataList[position].keyWord = currentKeywordView.getText().toString()
    }

    // キーワードを追加する
    private fun addKeyword(newKeyword: String) {
        val newSiritoriData = SiritoriData()
        newSiritoriData.keyWord = newKeyword
        newSiritoriData.idea = ""
        siritoriDataList.add(newSiritoriData)
        notifyDataSetChanged() // これを忘れるとRecyclerViewにItemが反映されない
    }

    // 一番下のキーワードのViewから最後尾の文字を取得
    private fun getNextKeywordHeadString(latestKeywordView: EditText): String {
        val latestKeyword = latestKeywordView.getText().toString()
        val latestKeywordLength = latestKeywordView.getText().toString().length
        return latestKeyword.get(latestKeywordLength - 1).toString()
    }

}