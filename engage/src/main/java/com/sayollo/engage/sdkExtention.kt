package com.sayollo.engage

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Context.getAdsID(): String? {
    try {
        val context = this
        CoroutineScope(GlobalScope.launch {
            var idInfo: AdvertisingIdClient.Info? = null
            idInfo =
                AdvertisingIdClient.getAdvertisingIdInfo(context)
            idInfo.let {
                getSharedPreferences("engage_repo", Context.MODE_PRIVATE).edit().putString("gaid", idInfo.id)
                    .apply()
            }
        })
        return getSharedPreferences("engage_repo", Context.MODE_PRIVATE).getString("gaid", "")
    } catch (t: Throwable) {
        Log.i("TAMIR", "getAdsID: ${t.message}")
    }

    return ""
}

