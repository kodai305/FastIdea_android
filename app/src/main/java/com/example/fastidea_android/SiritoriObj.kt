package com.example.fastidea_android

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class SiritoriObj : RealmObject() {
    @PrimaryKey
    open var id : String = ""

    @Required
    open var theme : String = ""
    open var SiritoriDataList: RealmList<SiritoriData>? = null
}


open class SiritoriData : RealmObject() {
    @PrimaryKey
    open var id : Int? = null

    open var keyWord : String = ""
    open var idea : String = ""
}