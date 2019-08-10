package com.example.fastidea_android

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText

class SiritoriMainListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    // インターフェースを切っておく、実処理はSiritoriActivityで書く
    interface CellTappedListener {
        fun onCellTapped(tappedView: View, data: SiritoriMainData)
    }

    val keywordView: EditText = itemView.findViewById(R.id.siritori_keyword)
    val ideaView: EditText = itemView.findViewById(R.id.siritori_idea)
}