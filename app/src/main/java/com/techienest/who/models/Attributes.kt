package com.techienest.who.models

import com.google.gson.annotations.SerializedName

data class Attributes (

    @SerializedName("CumCase")
    val CumCase : Int = 0,

    @SerializedName("CumDeath")
    val CumDeath : Int = 0,

    @SerializedName("OBJECTID")
    val OBJECTID : Int = 0
)
