package com.sayollo.engage

import android.content.Context
import android.content.pm.PackageManager
import android.webkit.WebSettings
import com.sayollo.engage.api.DefaultGamePlayAPI
import com.sayollo.engage.api.OnGamePlayDataChanged
import com.sayollo.engage.util.getAdsID
import java.util.*

object Engage {
    private lateinit var userProfile: UserProfile
    fun initSdk(context: Context): InitResult {
        // initialize user profile
        userProfile = initUserProfile(context)

        val onGamePlayDataChanged  = object : OnGamePlayDataChanged {
            override fun onChanged(userGameData: UserGameData) {
                UpdateDataInServer.run(UserData(userProfile, userGameData))
            }
        }

        // return the user API for GamePlay integration
        return InitResult.InitSuccess(DefaultGamePlayAPI(DefaultEngageRepo(context),onGamePlayDataChanged))
    }

    private fun initUserProfile(context: Context): UserProfile {
        val app = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
        val bundle = app.metaData
        val developerName = bundle.getString("engage_sdk")
        val adsId = context.getAdsID()
        val userAgent = WebSettings.getDefaultUserAgent(context)
        val packageName = context.packageName
        val locale = Locale.getDefault().language
        return UserProfile(developerName, adsId, userAgent, packageName, locale)
    }
}