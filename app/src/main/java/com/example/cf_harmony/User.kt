package com.example.cf_harmony

class User {
    var patientid: String? = null
    var uid: String? = null
    var cftype: String? = null
    var sym: String? = null

    constructor(){}
    constructor(patientid: String?, uid: String?, cftype: String?, sym: String?){
        this.patientid = patientid
        this.uid = uid
        this.cftype = cftype
        this.sym = sym

    }
}