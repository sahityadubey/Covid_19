package com.techienest.who.models

import com.google.gson.annotations.SerializedName

data class CovidData (

    @SerializedName("objectIdFieldName")
    var objectIdFieldName : String? = null,

    @SerializedName("uniqueIdField")
    var uniqueIdField : UniqueIdField? = null,

    @SerializedName("globalIdFieldName")
    var globalIdFieldName : String? = null,

    @SerializedName("geometryType")
    var geometryType : String? = null,

    @SerializedName("spatialReference")
    var spatialReference : SpatialReference? = null,

    @SerializedName("fields")
    var fields : List<Fields?>? = null,

    @SerializedName("exceededTransferLimit")
    var exceededTransferLimit : Boolean = false,

    @SerializedName("features")
    var features : List<Features>? = null
)