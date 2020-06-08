package com.techienest.who.network

import com.techienest.who.models.CovidData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IGetDataAPI {
    @GET("query")
    suspend fun getCovidData(
        @Query("where") ds: String,
        @Query("objectIds") objectIds: String,
        @Query("time") time: String,
        @Query("geometry") geometry: String,
        @Query("geometryType") geometryType: String,
        @Query("inSR") inSR: String,
        @Query("spatialRel") spatialRel: String,
        @Query("resultType") resultType: String,
        @Query("distance") distance: Double,
        @Query("units") units: String,
        @Query("returnGeodetic") returnGeodetic: Boolean,
        @Query("outFields") outFields: String,
        @Query("returnGeometry") returnGeometry: Boolean,
        @Query("featureEncoding") featureEncoding: String,
        @Query("multipatchOption") multipatchOption: String,
        @Query("maxAllowableOffset") maxAllowableOffset: String,
        @Query("geometryPrecision") geometryPrecision: String,
        @Query("outSR") outSR: String,
        @Query("datumTransformation") datumTransformation: String,
        @Query("applyVCSProjection") applyVCSProjection: Boolean,
        @Query("returnIdsOnly") returnIdsOnly: Boolean,
        @Query("returnUniqueIdsOnly") returnUniqueIdsOnly: Boolean,
        @Query("returnCountOnly") returnCountOnly: Boolean,
        @Query("returnExtentOnly") returnExtentOnly: Boolean,
        @Query("returnQueryGeometry") returnQueryGeometry: Boolean,
        @Query("returnDistinctValues") returnDistinctValues: Boolean,
        @Query("cacheHint") cacheHint: Boolean,
        @Query("orderByFields") orderByFields: String,
        @Query("groupByFieldsForStatistics") groupByFieldsForStatistics: String,
        @Query("outStatistics") outStatistics: String,
        @Query("having") having: String,
        @Query("resultOffset") resultOffset: String,
        @Query("resultRecordCount") resultRecordCount: Int,
        @Query("returnZ") returnZ: Boolean,
        @Query("returnM") returnM: Boolean,
        @Query("returnExceededLimitFeatures") returnExceededLimitFeatures: Boolean,
        @Query("quantizationParameters") quantizationParameters: String,
        @Query("sqlFormat") sqlFormat: String,
        @Query("f") f: String,
        @Query("token") token: String
    ): CovidData
}