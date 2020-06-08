package com.techienest.who.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.techienest.who.models.CovidData
import com.techienest.who.R
import com.techienest.who.base.BaseFragment
import com.techienest.who.constants.StringConstant
import com.techienest.who.utils.GetCountryDetails
import kotlinx.android.synthetic.main.fragment_second_view.view.*
import java.text.NumberFormat

class SecondViewFragment : BaseFragment() {
    private lateinit var uiView : View
    lateinit var countryNameString : String
    lateinit var totalConfirmedCase : String
    lateinit var totaDeathCount : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBlock()
        observerBlock()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        uiView = inflater.inflate(R.layout.fragment_second_view, container, false)
        return uiView;
    }

    override fun onResume() {
        super.onResume()

        //Updating UI
        getAndUpdateDataFromAPI()
    }

    private fun observerBlock(){
        viewModel.getCovidDataFromRepository()?.observe(this, Observer { data -> dataRecieved(data) })
    }

    private fun dataRecieved(covidData: CovidData?){
        countryNameString = if(countryName == null || countryName == "")  getString(R.string.country_str) else countryName + getString(R.string.country_str)
        totalConfirmedCase = if(covidData?.features?.first()?.attributes?.CumCase == null) getString(R.string.confirmed_count_str) else NumberFormat.getIntegerInstance().format(covidData.features?.first()?.attributes?.CumCase)
        totaDeathCount = if(covidData?.features?.first()?.attributes?.CumDeath == null) getString(R.string.total_deaths_count_str) else NumberFormat.getIntegerInstance().format(covidData.features?.first()?.attributes?.CumDeath)

        if(covidData != null) {
            setTextOnUI(countryNameString, totalConfirmedCase, totaDeathCount)
            saveDataInPreferences()
        }
        else{
            makeToast(getString(R.string.network_error))
        }
    }

    //UI set text
    private fun setTextOnUI(countryCode: String, totalCase: String, totalDeath: String){
        uiView.countryName.text = countryCode
        uiView.totalConfirmed.text = totalCase
        uiView.totalDeaths.text = totalDeath
    }

    private fun saveDataInPreferences(){
        val sharedPrefEditior = mPreferences.edit()
        sharedPrefEditior.putString(StringConstant().totalCasesKey,totalConfirmedCase)
        sharedPrefEditior.putString(StringConstant().totalDeathKey,totaDeathCount)
        sharedPrefEditior.apply()
    }

    private fun getAndUpdateDataFromAPI(){
        //Get old data
        if(!isNetworkAvailable() && getSavedData(StringConstant().totalCasesKey) != null) {
            setTextOnUI(GetCountryDetails().getCountryCode() + getString(R.string.country_str), getSavedData(StringConstant().totalCasesKey).toString(), getSavedData(StringConstant().totalDeathKey).toString())
            makeSnakeBar(uiView, getString(R.string.old_data_uploaded))
        }
        //Get default data
        else if(!isNetworkAvailable()) {
            setTextOnUI(getString(R.string.country_situtation_str), getString(R.string.confirmed_count_str),getString(R.string.total_deaths_str))
            makeSnakeBar(uiView, getString(R.string.network_not_available))
        }
    }
}
