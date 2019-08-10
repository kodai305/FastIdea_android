package com.example.fastidea_android

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.TextView

// Viewへの参照をもっておくViewHolder
class ListThemeHolder(view: View) : RecyclerView.ViewHolder(view) {
    val theme = view.findViewById<TextView>(R.id.theme)
}