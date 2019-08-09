package com.example.fastidea_android

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*
import io.realm.RealmList



open class MandaraObj : RealmObject() {
    @PrimaryKey
    open var id : String = ""

    @Required
    open var theme : String = ""

    open var createdTime: Date? = null
    open var modifiedTime: Date? = null
    open var mandaraParentData: RealmList<MandaraParentData>? = null

}

open class MandaraParentData : RealmObject() {
    @PrimaryKey
    open var id : Int? = null

    open var idea : String = ""
    open var mandaraChildData: RealmList<MandaraChildData>? = null
}

open class MandaraChildData : RealmObject() {
    @PrimaryKey
    open var id : Int? = null

    open var idea : String = ""
}