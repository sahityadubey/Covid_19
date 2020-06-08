package com.techienest.who.models

import com.google.gson.annotations.SerializedName

data class UniqueIdField (
    @SerializedName("name")
    val name : String? = null,

    @SerializedName("isSystemMaintained")
    val isSystemMaintained : Boolean = false
)