package com.techienest.who.models

import com.google.gson.annotations.SerializedName

data class Fields (
    @SerializedName("name")
    val name : String? = null,

    @SerializedName("type")
    val type : String? = null,

    @SerializedName("alias")
    val alias : String? = null,

    @SerializedName("sqlType")
    val sqlType : String? = null,

    @SerializedName("domain")
    val domain : String? = null,

    @SerializedName("defaultValue")
    val defaultValue : String? = null
)