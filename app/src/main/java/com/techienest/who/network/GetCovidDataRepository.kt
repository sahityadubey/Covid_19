package com.techienest.who.network

import com.techienest.who.constants.StringConstant

class GetCovidDataRepository {
    var client: IGetDataAPI = RetrofitService.webservice

    //API calling function
    //We need to define all parameters, as the URL was given in the encoded string which is not supported directly to pass as a parameter
    suspend fun getCovidData(countryCode: String) = client.getCovidData("ISO_2_CODE='${countryCode}'", StringConstant().emptyString, StringConstant().emptyString, StringConstant().emptyString, "esriGeometryEnvelope", StringConstant().emptyString,"esriSpatialRelIntersects","none",0.0,"esriSRUnit_Meter",false,"CumCase,CumDeath", false,"esriDefault","xyFootprint", StringConstant().emptyString, StringConstant().emptyString, StringConstant().emptyString, StringConstant().emptyString,false,false,false,false,false,false,false,false,"date_epicrv DESC", StringConstant().emptyString, StringConstant().emptyString, StringConstant().emptyString, StringConstant().emptyString,1,false,false,true, StringConstant().emptyString,"none","pjson", StringConstant().emptyString)

    //Singleton variable for repository instance
    companion object {
        private var getCovidDataRepository: GetCovidDataRepository? = null
        val instance: GetCovidDataRepository?
        get()
        {
            if (getCovidDataRepository == null)
            {
                getCovidDataRepository = GetCovidDataRepository()
            }
            return getCovidDataRepository
        }
    }
}