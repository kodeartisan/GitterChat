package com.devslopes.datafrost1997.gitterchat.Model

/**
 * Created by datafrost1997 on 16/10/17.
 */
class Channel (val name: String, val description: String, val id: String){
    override fun toString(): String {
        return "#$name"
    }
}