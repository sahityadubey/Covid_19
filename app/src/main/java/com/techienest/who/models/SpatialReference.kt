package com.techienest.who.models

import com.google.gson.annotations.SerializedName

data class SpatialReference (
    @SerializedName("wkid")
    val wkid : Int? = null,

    @SerializedName("latestWkid")
    val latestWkid : Int? = null
)