package com.sayollo.engage.api

import com.sayollo.engage.Engage
import com.sayollo.engage.UpdateDataInServer
import com.sayollo.engage.UserData
import com.sayollo.engage.UserGameData

interface OnGamePlayDataChanged {

    fun onChanged(userGameData: UserGameData)
}
