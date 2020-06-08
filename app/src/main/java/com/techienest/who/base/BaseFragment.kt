package com.techienest.who.base

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.techienest.who.models.CovidData
import com.techienest.who.constants.StringConstant
import com.techienest.who.utils.GetCountryDetails
import com.techienest.who.viewmodels.HomeViewModel

abstract class BaseFragment : Fragment(){
    protected lateinit var mPreferences: SharedPreferences
    protected lateinit var viewModel : HomeViewModel
    protected var countryName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPreferences = context?.getSharedPreferences(StringConstant().packageName, MODE_PRIVATE)!!
    }

    protected fun initBlock(){
        countryName = GetCountryDetails().getCountryCode()
        viewModel = ViewModelProviders.of(requireActivity()).get(HomeViewModel::class.java)
    }

    protected fun isNetworkAvailable(): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    protected fun getSavedData(key: String) : String?{
        return mPreferences.getString(key, null);
    }

    protected fun makeToast(text : String){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
    }

    protected fun makeSnakeBar(view: View, text: String) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
    }
}

