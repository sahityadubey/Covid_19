package com.techienest.who.utils

import android.content.Context
import android.net.ConnectivityManager
import android.os.StrictMode
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.URL
import java.net.UnknownHostException

class GetConnectionStatus {

    fun connectionStatus(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun hasActiveInternetConnection(): Boolean {
        val policy = StrictMode.ThreadPolicy.Builder()
            .permitAll()
            .build()
        StrictMode.setThreadPolicy(policy)
        try {
            val url = URL("https://www.google.com")
            val urlConnection = (url.openConnection() as HttpURLConnection).apply {
                setRequestProperty("User-Agent", "Test")
                setRequestProperty("Connection", "close")
                connectTimeout = 8000
                connect()
            }
            return urlConnection.responseCode == 200
        } catch (e: UnknownHostException) {
            Log.e("UnknownHostException", e.toString())
        } catch (se: SocketTimeoutException) {
            Log.e("SocketTimeoutException", se.toString())
        } catch (io: IOException) {
            Log.e("IOException", io.toString())
        }
            return false
        }
}