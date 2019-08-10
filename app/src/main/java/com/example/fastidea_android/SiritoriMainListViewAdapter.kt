package com.example.fastidea_android

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SiritoriMainListViewAdapter(private val mainList: List<SiritoriMainData>, private val listener: SiritoriMainListViewHolder.CellTappedListener) : RecyclerView.Adapter<SiritoriMainListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiritoriMainListViewHolder {
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.siritori_main_list_cell, parent, false)
        return SiritoriMainListViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: SiritoriMainListViewHolder, position: Int) {
        // EditTextの初期値を設定
        holder.keywordView.setText(mainList[position].keyWord, TextView.BufferType.NORMAL)
        holder.ideaView.setText(mainList[position].idea, TextView.BufferType.NORMAL)
        holder.itemView.setOnClickListener {
            listener.onCellTapped(it, mainList[position])
        }
    }

    override fun getItemCount(): Int {
        return mainList.size
    }
}