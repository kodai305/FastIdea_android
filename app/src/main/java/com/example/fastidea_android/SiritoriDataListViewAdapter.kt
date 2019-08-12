package com.example.fastidea_android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        holder.addKeywordButton.setOnClickListener{
            this.addKeyword("test")
        }
        holder.itemView.setOnClickListener {
            listener.onCellTapped(it, siritoriDataList[position])
        }
    }

    override fun getItemCount(): Int {
        return siritoriDataList.size
    }

    // キーワードを追加する
    fun addKeyword(newKeyword: String) {
        val newSiritoriData = SiritoriData()
        newSiritoriData.keyWord = newKeyword
        newSiritoriData.idea = ""
        siritoriDataList.add(newSiritoriData)
        notifyDataSetChanged() // これを忘れるとRecyclerViewにItemが反映されない
    }

}