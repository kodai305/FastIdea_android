package com.example.fastidea_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.Gravity
import android.view.ViewGroup
import android.widget.TableLayout
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.EditText
import android.widget.TableRow

class Mandara : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // デバック用
        setContentView(R.layout.activity_mandara)


        if(supportFragmentManager.findFragmentByTag("MandaraParentFragment") == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container_center, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_left, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_right, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()

            supportFragmentManager.beginTransaction()
                .add(R.id.container_avobe, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_leftabove, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_rightabove, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()

            supportFragmentManager.beginTransaction()
                .add(R.id.container_below, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_leftbelow, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.container_rightbelow, newMandaraParentFragment(), "MandaraParentFragment")
                .commit()
        }


        /*
        失敗作
        val parent_tableLayout = TableLayout(this)
        //parent_tableLayout.setGravity(Gravity.CENTER_HORIZONTAL); // android:gravity="center" 相当らしい
        parent_tableLayout.setVerticalGravity(Gravity.CENTER)
        parent_tableLayout.setHorizontalGravity(Gravity.CENTER)

        setContentView(parent_tableLayout, ViewGroup.LayoutParams(300,300))
        //setContentView(parent_tableLayout, ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT))

        for (i in 1..3) {
            val tableRow = TableRow(this)
            for (j in 1..3) {
                val editText = EditText(this)
                editText.setWidth(100)
                editText.setText(String.format("[%d番目]", ((i-1)+3)+j))

                tableRow.addView(editText)

            }
            parent_tableLayout.addView(tableRow);
        }
        */

    }
}
