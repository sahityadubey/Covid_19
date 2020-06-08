package com.techienest.who.utils

import android.content.res.Resources
import androidx.core.os.ConfigurationCompat

class GetCountryDetails {

    fun getCountryCode(): String {
        return ConfigurationCompat.getLocales(Resources.getSystem().configuration)
            .get(0).country
    }

    fun getCountryName(): String {
        return ConfigurationCompat.getLocales(Resources.getSystem().configuration)
            .get(0).getDisplayCountry()
    }
}