package com.sayollo.engage.util

import android.content.Context
import android.util.Log
import android.webkit.WebSettings
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import java.util.*


fun Context.getAdsID(): String? {
    try {
        var idInfo: AdvertisingIdClient.Info? = null
        idInfo =
            AdvertisingIdClient.getAdvertisingIdInfo(this.applicationContext)
        idInfo.let {
            return idInfo.id
        }
    } catch (t: Throwable) {
        Log.i("TAMIR", "getAdsID: ${t.message}")
    }

    return ""
}

fun Context.getHeaders(): Map<String, String> {
    val headerMap = mutableMapOf<String, String>()
    headerMap["Content-Encoding"] = "gzip"
    headerMap["User-Agent"] = WebSettings.getDefaultUserAgent(this)
    headerMap["Package-Name"] = packageName
    headerMap["Locale"] = Locale.getDefault().language
    headerMap["Content-Type"] = "application/x-www-form-urlencoded"
    return headerMap
}



