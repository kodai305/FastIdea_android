package com.example.fastidea_android

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class MandaraObj : RealmObject() {
    @PrimaryKey
    open var id : String = ""

    @Required
    open var theme : String = ""

}