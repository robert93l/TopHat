package com.tophat.android_interview_kotlin_setup.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkConnectionUtils {
    @JvmStatic
    fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}