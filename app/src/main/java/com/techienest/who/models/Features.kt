package com.techienest.who.models

import com.google.gson.annotations.SerializedName

data class Features (
    @SerializedName("attributes")
    val attributes : Attributes? = null
)