package com.sayollo.engage.api

import com.sayollo.engage.data.UserGameData

internal interface OnGamePlayDataChanged {
    fun onChanged(userGameData: UserGameData)
}
