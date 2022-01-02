package com.sayollo.engage.util

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient

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




